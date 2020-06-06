// Write an algorithm to determine if a number is "happy".
// A happy number is a number defined by the following process: 
// Starting with any positive integer, replace the number by the sum of the squares of its digits, 
// and repeat the process until the number equals 1 (where it will stay), 
// or it loops endlessly in a cycle which does not include 1. 
// Those numbers for which this process ends in 1 are happy numbers.\
// See: https://leetcode.com/problems/happy-number/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/

package leetcode.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> used = new HashSet<>();

        for (int currSum = getSum(n);; currSum = getSum(currSum)) {
            if (currSum == 1)
                return true;
            if (used.contains(currSum))
                return false;
            used.add(currSum);
        }
    }

    private int getSum(int num) {
        if (num == 0)
            return 0;
        return (num % 10) * (num % 10) + getSum(num / 10);
    }

    public static void main(String[] args) {
        HappyNumber sln = new HappyNumber();
        System.out.println(sln.isHappy(19));
        System.out.println(sln.isHappy(20));
    }

}
