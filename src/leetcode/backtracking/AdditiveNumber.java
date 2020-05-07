// Additive number is a string whose digits can form additive sequence.
// A valid additive sequence should contain at least three numbers. Except for the first two numbers, 
// each subsequent number in the sequence must be the sum of the preceding two.
// Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
// Follow up: How would you handle overflow for very large input integers?
// See: https://leetcode.com/problems/additive-number/
// Connected problem: https://leetcode.com/problems/split-array-into-fibonacci-sequence/

package leetcode.backtracking;

public class AdditiveNumber {

    /**
     * Iterative non-backtracking solution. Moreover that this problem is labeled as
     * "Backtracking" I didn't find using a backtracking here as very intuitive.
     */
    // TODO: Try to find easier and intuitive backtracking solution.
    public boolean isAdditiveNumber(String num) {
        char[] digits = num.toCharArray();
        long num1 = 0;
        for (int i = 0; i < digits.length / 2; i++) {
            if (digits[0] == '0' && i > 0) continue; // the number starts with 0 and becomes > 0

            num1 = num1 * 10 + (digits[i] - '0');
            long num2 = 0;
            for (int j = i + 1; j < digits.length - 1; j++) {
                num2 = num2 * 10 + (digits[j] - '0');
                if (isAdditiveSplit(digits, num1, num2, j)) return true;

                if (digits[i + 1] == '0') break; // the number starts with 0 and becomes > 0
            }
        }

        return false;
    }

    private boolean isAdditiveSplit(char[] digits, long num1, long num2, int end) {
        while (end < digits.length - 1) {
            char[] target = String.valueOf(num1 + num2).toCharArray();
            for (int i = end + 1; i < end + target.length + 1; i++)
                if (i < digits.length && digits[i] != target[i - end - 1]) return false;
            
            long tmp = num2;
            num2 = num1 + num2;
            num1 = tmp;
            end = end + target.length;
        }

        return true;
    }

    public static void main(String[] args) {
        AdditiveNumber sln = new AdditiveNumber();

        System.out.println(sln.isAdditiveSplit("199100199".toCharArray(), 1, 99, 2));
        System.out.println(sln.isAdditiveSplit("112358".toCharArray(), 1, 1, 1));
        System.out.println(sln.isAdditiveSplit("112358".toCharArray(), 1, 12, 2));

        System.out.println(sln.isAdditiveNumber("199100199")); // true
        System.out.println(sln.isAdditiveNumber("112358")); // true
        System.out.println(sln.isAdditiveNumber("1123588")); // false
        System.out.println(sln.isAdditiveNumber("1023")); // false
        System.out.println(sln.isAdditiveNumber("101")); // true
        System.out.println(sln.isAdditiveNumber("0235813")); // false
        System.out.println(sln.isAdditiveNumber("000")); // true
        System.out.println(sln.isAdditiveNumber("12122436")); // true
        System.out.println(sln.isAdditiveNumber("11235813213455890144")); // false
    }

}
