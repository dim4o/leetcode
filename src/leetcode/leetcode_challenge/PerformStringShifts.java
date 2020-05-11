// You are given a string s containing lowercase English letters, and a matrix shift, 
// where shift[i] = [direction, amount]:
//   - direction can be 0 (for left shift) or 1 (for right shift). 
//   - amount is the amount by which string s is to be shifted.
//   -  A left shift by 1 means remove the first character of s and append it to the end.
//   - Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
// Return the final string after all operations.
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/

package leetcode.leetcode_challenge;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PerformStringShifts {

    /**
     * Simple solution with Deque (accepted).
     */
    public String stringShift(String s, int[][] shift) {
        Deque<String> dq = new LinkedList<>(Arrays.asList(s.split("")));
        for (int[] currOp : shift) {
            int direction = currOp[0];
            int amount = currOp[1] % s.length();
            if (direction == 0)
                for (int i = 0; i < amount; i++)
                    dq.addLast(dq.pollFirst());
            else
                for (int i = 0; i < amount; i++)
                    dq.addFirst(dq.pollLast());
        }

        return String.join("", dq);
    }

    public static void main(String[] args) {
        PerformStringShifts sln = new PerformStringShifts();

        System.out.println(sln.stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }));
        System.out.println(
                sln.stringShift("abcdefg", new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } }));

    }

}
