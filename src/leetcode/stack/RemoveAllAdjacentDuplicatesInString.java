// Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
// We repeatedly make duplicate removals on S until we no longer can.
// Return the final string after all such duplicate removals have been made.
// It is guaranteed the answer is unique.
// See: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

package leetcode.stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        // the idea is to use the StringBuilder as a stack
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            char currChar = S.charAt(i);
            // "charAt(lastPosition)" is like stack.peek()
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == currChar) { 
                sb.setLength(sb.length() - 1); // like stack.pop()
            } else {
                sb.append(currChar); // like stack.push()
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString sln = new RemoveAllAdjacentDuplicatesInString();
        
        System.out.println(sln.removeDuplicates("abbaca"));
        System.out.println(sln.removeDuplicates(""));
        System.out.println(sln.removeDuplicates("abc"));

    }

}
