// The gray code is a binary numeral system where two successive values differ in only one bit.
// Given a non-negative integer n representing the total number of bits in the code, 
// print the sequence of gray code. A gray code sequence must begin with 0.
// See: https://leetcode.com/problems/gray-code/

package leetcode.backtracking;

import java.util.Collections;
import java.util.LinkedList;

public class GrayCode {
    /**
     * Slow but concise and intuitive solution
     * A memorization can boost the performance
     * TODO: Try to add a memo map
     */
    public LinkedList<Integer> grayCode(int n) {
        if (n == 0) {
            LinkedList<Integer> floorRes = new LinkedList<>();
            floorRes.add(0);
            return floorRes;
        }

        // Two lists with the previous result for (n - 1)
        LinkedList<Integer> prev0 = grayCode(n - 1);
        LinkedList<Integer> prev1 = new LinkedList<>(prev0);
        
        for (int i = 0; i < prev1.size(); i++) {
            // Add 0 at the end of the binary representation
            prev0.set(i, prev0.get(i) << 1);
            // Add 1 at the end of the binary representation
            prev1.set(i, (prev1.get(i) << 1) | 1);
        }
        
        // Combines the above list:
        Collections.reverse(prev1);
        for (Integer currRes : prev1)
            prev0.addLast(currRes);
        
        return prev0;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2));
    }

}
