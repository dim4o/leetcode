// Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
// See: https://leetcode.com/problems/maximum-sum-circular-subarray/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/

package leetcode.array_and_hashtable;

public class MaximumSumCircularSubarray {
    
    /**
     * Note: this is a hard problem although is labeled as medium.
     * For explanation:
     * @see: https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
     * @see: https://leetcode.com/problems/maximum-sum-circular-subarray/solution/
     */
    public int maxSubarraySumCircular(int[] A) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        int min = Integer.MAX_VALUE;
        int curMin = 0;
        for (int num : A) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);
            total += num;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
    
    /**
     * Solution 1 with cashed sums - not accepted due Time Limit
     * Very easy, short and intuitive but slow solution.
     */
    public int maxSubarraySumCircular_var1(int[] A) {
        int[] sums = new int[A.length * 2 + 1];
        for (int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + A[i % A.length];
       
        int max = sums[1];
        for (int i = 1; i < sums.length; i++) {
            int end = Math.min(i + A.length, sums.length);
            for (int j = i; j < end; j++)
                max = Math.max(max, sums[j] - sums[i - 1]);
        }        
        return max;
    }
    

    public static void main(String[] args) {
        MaximumSumCircularSubarray sln = new MaximumSumCircularSubarray();
        
        System.out.println(sln.maxSubarraySumCircular(new int[] {1,-2,3,-2}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {5,-3,5}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {3,-1,2,-1}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {3,-2,2,-3}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {-2,-3,-1}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {-1, -2, -3}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {2,-2,2,7,8,0}));
        System.out.println(sln.maxSubarraySumCircular(new int[] {0,5,8,-9,9,-7,3,-2}));
    }

}
