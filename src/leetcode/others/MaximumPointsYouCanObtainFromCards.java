// There are several cards arranged in a row, and each card has an associated number of points.
// The points are given in the integer array cardPoints.
// In one step, you can take one card from the beginning or from the end of the row. 
// You have to take exactly k cards.
// Your score is the sum of the points of the cards you have taken.
// Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
// See: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

package leetcode.others;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsYouCanObtainFromCards {
    /**
     * Sliding window solution - accepted.
     */
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int[] cSum = new int[cardPoints.length + 1];
        for (int i = 1; i < cSum.length; i++) 
            cSum[i] = cSum[i - 1] + cardPoints[i - 1];
        
        int windowSize = cardPoints.length - k;
        int sum = cSum[cSum.length - 1];
        for (int i = 0; i <= k; i++)
            ans = Math.max(ans, sum - (cSum[i + windowSize] - cSum[i]));
        
        return ans;
    }

    /**
     * Recursion with memorization - still not accepted(TLE)
     */
    public int maxScore_memo(int[] cardPoints, int k) {
        return score(cardPoints, k, 0, cardPoints.length - 1, new HashMap<>());
    }

    private int score(int[] points, int k, int l, int r, Map<String, Integer> memo) {
        if (k == 0 || l > r)
            return 0;

        String k1 = (l + 1) + "," + r;
        String k2 = l + "," + (r - 1);

        if (!memo.containsKey(k1))
            memo.put(k1, score(points, k - 1, l + 1, r, memo));

        if (!memo.containsKey(k2))
            memo.put(k2, score(points, k - 1, l, r - 1, memo));

        return Math.max(points[l] + memo.get(k1), points[r] + memo.get(k2));
    }

    /**
     * Clean recursion - not accepted(TLE)
     */
    public int maxScore_recur(int[] cardPoints, int k) {
        return calc(cardPoints, k, 0, cardPoints.length - 1);
    }

    private int calc(int[] points, int k, int l, int r) {
        if (k == 0 || l > r)
            return 0;

        return Math.max(points[l] + calc(points, k - 1, l + 1, r),
                points[r] + calc(points, k - 1, l, r - 1));
    }

    public static void main(String[] args) {
        MaximumPointsYouCanObtainFromCards sln = new MaximumPointsYouCanObtainFromCards();

        System.out.println(sln.maxScore(new int[] { 1, 79, 80, 1, 1, 1, 200, 1 }, 3));
        System.out.println(sln.maxScore(new int[] { 1, 1000, 1 }, 1));
        System.out.println(sln.maxScore(new int[] { 9, 7, 7, 9, 7, 7, 9 }, 7));
        System.out.println(sln.maxScore(new int[] { 2, 2, 2 }, 2));
        System.out.println(sln.maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3));

    }

}
