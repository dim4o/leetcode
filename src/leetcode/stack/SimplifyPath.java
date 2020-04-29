// Given an absolute path for a file (Unix-style), simplify it. Or in other words, 
// convert it to the canonical path.
// In a UNIX-style file system, a period . refers to the current directory. 
// Furthermore, a double period .. moves the directory up a level.
// Note that the returned canonical path must always begin with a slash /, 
// and there must be only a single slash / between two directory names. 
// The last directory name (if it exists) must not end with a trailing /. 
// Also, the canonical path must be the shortest string representing the absolute path.
// See: https://leetcode.com/problems/simplify-path/
// See: https://leetcode.com/problems/simplify-path/discuss/603200/Java-Slow-but-Concise-Solution

package leetcode.stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] arr = path.replaceAll("/+", "/").split("/");
        Stack<String> st = new Stack<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!st.empty())
                    st.pop();
            } else if (!arr[i].equals("."))
                st.add(arr[i]);
        }

        return "/" + String.join("/", st);
    }

    public static void main(String[] args) {
        SimplifyPath sln = new SimplifyPath();
        System.out.println(sln.simplifyPath("/"));
        System.out.println(sln.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(sln.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(sln.simplifyPath("/a/./b/../../c/"));

    }

}
