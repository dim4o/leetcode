import git
import re
import os
from collections import defaultdict


def generate_class_name(title):
    """ Generates the file solution file name based on my convention """
    generated_name = title
    generated_name = generated_name.replace("IV", "4").replace("III", "3").replace("II", "2").replace("-", "")
    words = generated_name.split()
    first = re.match("(\d+)(.*)", words[0])
    if first:
        words[0] = first.group(2)
        words.append(first.group(1))
    words.append(".java")
    return "".join(words)


def parse_commits():
    """ Parse the commits to a set of items (title, url) """
    repo = git.Repo("./.git")
    commits = list(repo.iter_commits("master"))
    commit_items_set = set()
    for commit in commits:
        message_match = re.search("\"(.*?)\"", commit.message)
        link_match = re.search("https://leetcode.com/.*", commit.message)
        title, url = "", ""
        if message_match:
            title = message_match.group(1)
        if link_match:
            url = link_match.group(0)

        if title and url:
            # print(url)
            commit_items_set.add((title, url))
    return commit_items_set


def get_all_java_files():
    all_files = {}
    for root, dirs, files in os.walk("./src"):
        for file in files:
            if file.endswith(".java") or file.endswith(".sql"):
                all_files[file] = os.path.join(root, file)
    return all_files


def get_edit_distance(first_str, second_str):
    """ Finds the minimum distance between two strings
    :return: the normalized distance
    """

    def calc_edit_distance(first_str, second_str):
        rows = len(first_str) + 1
        cols = len(second_str) + 1
        matrix = [[0] * cols for _ in range(rows)]

        for row in range(1, rows):
            matrix[row][0] = row
            for col in range(1, cols):
                matrix[0][col] = col
                substitution_cost = 0 if first_str[row - 1] == second_str[col - 1] else 1
                matrix[row][col] = min(matrix[row - 1][col] + 1, matrix[row][col - 1] + 1,
                                       matrix[row - 1][col - 1] + substitution_cost)
        return matrix[rows - 1][cols - 1]

    # find and normalize the minimum edit distance
    longer_str = max(len(first_str), len(second_str))
    return (longer_str - calc_edit_distance(first_str, second_str)) / float(longer_str)


def find_best_match_class_name(generated_class_name, all_files):
    best_dist = 0.  # best distance is 1, worst is 0
    best_match = None
    for candidate, local_path in all_files.items():
        curr_dist = get_edit_distance(generated_class_name, candidate)
        if curr_dist > best_dist:
            category = re.match("./src/leetcode/(.*)/.*.java", local_path) or re.match("./src/leetcode/(.*)/.*.sql", local_path)
            category = category.group(1)
            best_match = (candidate, local_path, category)
            best_dist = curr_dist

    return best_match


def remove_duplicates(items):
    """ Removes the duplicates due inconsistent commit messages """
    print(items)
    items.remove(("Reverse LinkedList", "https://leetcode.com/problems/reverse-linked-list/"))
    items.remove(("Counting Elements",
                  "https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/"))
    items.remove(("Add and Search Word - Data structure design",
                 "https://leetcode.com/problems/add-and-search-word-data-structure-design/"))
    items.add(("Product of the Last K Numbers",
               "https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/"))
    return items


if __name__ == '__main__':
    items = parse_commits()
    items = remove_duplicates(items)

    # print(len(items))

    all_files_dict = get_all_java_files()
    category_map = defaultdict(list)

    for item in items:
        title, url = item
        candidate, local_path, category = find_best_match_class_name(generate_class_name(title), all_files_dict)
        category_map[category].append((title, url, candidate, local_path))

    # category_map.pop("unfinished")

    sorted_category_map = {k: category_map[k] for k in sorted(category_map)}

    with open("./README.md", 'w') as file:
        file.write("# My Solutions of some LeetCode problems\n\n")
        file.write("(This item is generated with [update-readme.py](./update-readme.py).)\n\n")
        file.write("{} solved problems from {} categories:\n".format(len(items), len(sorted_category_map)))

        for category, val in sorted_category_map.items():
            file.write(
                "* [{}](#{}) - {} problems\n".format(category.title().replace("_", " "), category.replace("_", "-"),
                                                     len(val)))

        for category, item_list in sorted_category_map.items():
            file.write("## {}\n".format(category.title().replace("_", " ")))
            file.write("Index | Problem Description | My Solution |\n")
            file.write("--- | --- | ---\n")

            item_list = sorted(item_list, key=lambda x: x[0])

            for index, line in enumerate(item_list):
                title, url, candidate, local_path = line
                file.write("{} | [{}]({}) | [{}]({})\n".format(index + 1, title, url, candidate, local_path))

            file.write("\n")

        file.write("---\n")
        file.write("**Note:** This file is automatically generated based on the commits and the project structure. "
                   "Some of the information may be broken due the an inconsistency of the commits and the naming "
                   "conventions.\n\n")
        file.write("---\n")
