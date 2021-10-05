// Given an array nums of integers, return how many of them contain an even number of digits.
// See: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

package leetcode.array_and_hashtable;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (numOfDigits(num) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
    
    private int numOfDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits sln = new FindNumbersWithEvenNumberOfDigits();

        System.out.println(sln.findNumbers(new int[] {12,345,2,6,7896}));
    }

}
