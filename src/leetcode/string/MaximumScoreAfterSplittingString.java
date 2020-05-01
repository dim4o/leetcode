// Given a string s of zeros and ones, return the maximum score after splitting the string into 
// two non-empty substrings (i.e. left substring and right substring).
// The score after splitting a string is the number of zeros in the left substring plus the number 
// of ones in the right substring.
// See: https://leetcode.com/problems/maximum-score-after-splitting-a-string/

package leetcode.string;

public class MaximumScoreAfterSplittingString {
    /*
     * Straightforward solution.
     */
    public int maxScore(String s) {
        int max = 0, ones = 0, zeroes = 0;
        for (int i = 0; i < s.length(); i++) 
            if (s.charAt(i) == '1') ones++;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1')
                ones -= 1;
            else 
                zeroes += 1;
            max = Math.max(max, ones + zeroes);
        }

        return max;
    }

    /*
     * Recursive solution - accepted (for experimental purposes).
     */
    public int maxScore_recur(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1') ones++;

        getMax(s.toCharArray(), 0, 0, ones);
        return max;
    }
    int max = 0;
    private void getMax(char[] seq, int splitIdx, int zeroes, int ones) {
        if (splitIdx == seq.length - 1)
            return;

        int max = 0;
        if (seq[splitIdx] == '0') {
            max = Math.max(max, zeroes + 1 + ones);
            getMax(seq, splitIdx + 1, zeroes + 1, ones);
        } else {
            max = Math.max(max, zeroes + ones - 1);
            getMax(seq, splitIdx + 1, zeroes, ones - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumScoreAfterSplittingString().maxScore("00111"));
        System.out.println(new MaximumScoreAfterSplittingString().maxScore("1111"));
    }

}
