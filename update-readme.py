import git
import re
import os

# for best result keep this value high
BEST_MATCH_THRESHOLD = 0.9


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
        link_match = re.search("((\w+://\S+)|(\w+[.:]\w+\S+))[^\s,.]", commit.message)
        title, url = "", ""
        if message_match:
            title = message_match.group(1)
        if link_match:
            url = link_match.group(1)

        if title and url:
            commit_items_set.add((title, url))
    return commit_items_set


def get_all_java_files():
    all_files = {}
    for root, dirs, files in os.walk("./"):
        for file in files:
            if file.endswith(".java"):
                all_files[file] = os.path.join(root, file)
    return all_files


def get_min_edit_distance(first_str, second_str):
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
    for candidate, val in all_files.items():
        curr_dist = get_min_edit_distance(generated_class_name, candidate)
        if curr_dist > best_dist:
            best_dist = curr_dist
            best_match = (candidate, val)
        if best_dist >= BEST_MATCH_THRESHOLD:
            break
    return best_match


if __name__ == '__main__':
    sorted_items = sorted(parse_commits(), key=lambda x: x[0])
    all_files_dict = get_all_java_files()

    with open("./README.md", 'w') as file:
        file.write("# My Solutions of some LeetCode problems\n\n")

        file.write("Index | Problem  | My solution |\n")
        file.write("--- | --- | ---\n")

        for index, line in enumerate(sorted_items):
            title, url = line
            best_match = find_best_match_class_name(generate_class_name(title), all_files_dict)
            file.write("{} | [{}]({}) | [{}]({})\n".format(index + 1, title, url, best_match[0], best_match[1]))
