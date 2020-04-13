import git
import re

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

sorted_list = sorted(commit_items_set, key=lambda x: x[0])

with open("./README.md", 'w') as file:
    file.write("# My Solutions of some LeetCode problems\n\n")
    for index, line in enumerate(sorted_list):
        title, url = line
        file.write("{}. [{}]({})\n".format(index + 1, title, url))
