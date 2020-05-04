// An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
// See: https://leetcode.com/problems/sequential-digits/
// See: https://leetcode.com/problems/sequential-digits/discuss/613365/Java-Two-simple-solutions

package leetcode.backtracking;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SequentialDigits {
    /**
     * Recursive solution.
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new LinkedList<Integer>();
        
        for (int i = 1; i < 10; i++)
            recur(low, high, i, i + 1, ans);
        
        Collections.sort(ans);
        
        return ans;
    }

    private void recur(int lo, int hi, int currNum, int lastDigit, List<Integer> ans) {
        if (currNum > hi)
            return;
        
        if (lastDigit <= 10) {
            if (currNum >= lo && currNum <= hi)
                ans.add(currNum);
            recur(lo, hi, currNum * 10 + lastDigit, lastDigit + 1, ans);
        }
    }
    
    /*
     * Iterative solution.
     */
    public List<Integer> sequentialDigits_iter(int low, int high) {
        List<Integer> ans = new LinkedList<Integer>();

        for (int start = 1; start < 10; start++) {
            int curr = start;
            int last = curr + 1;
            while (curr <= high && last <= 10) {
                if (curr >= low)
                    ans.add(curr);
                curr = curr * 10 + last;
                last++;
            }
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
    public static void main(String[] args) {
        SequentialDigits sln = new SequentialDigits();
        System.out.println(sln.sequentialDigits(1000, 13000));
        System.out.println(sln.sequentialDigits(100, 300));
    }

}
