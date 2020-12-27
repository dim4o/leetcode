// You are given a list of songs where the ith song has a duration of time[i] seconds.
// Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
// Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
// See: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

package leetcode.array_and_hashtable;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    /**
     * Brute force - Time Limit Exceeded.
     */
    public int numPairsDivisibleBy60(int[] time) {
        for (int i = 0; i < time.length; i++) time[i] %= 60;
        int count = 0;
        for (int i = 0; i <time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var sln = new PairsOfSongsWithTotalDurationsDivisibleBy60();

        System.out.println(sln.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(sln.numPairsDivisibleBy60(new int[]{60, 60, 60}));
        System.out.println(sln.numPairsDivisibleBy60(new int[]{20, 40}));
    }
}
