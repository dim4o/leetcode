// Given an array A of integers, return the number of (contiguous, non-empty) 
// subarrays that have a sum divisible by K.
// See: https://leetcode.com/problems/subarray-sums-divisible-by-k/

package leetcode.array_and_hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    /**
     * Note: here I use the "modulo" operator which is different from the "reminder" operator.
     * In Java % is reminder operator.
     * In Python % is the actual mathematical "mod" operator.
     * For the purpose of the solution I use the "real" "mod" operator.
     * @see: https://stackoverflow.com/questions/13683563/whats-the-difference-between-mod-and-remainder
     * @see: https://stackoverflow.com/questions/11720656/modulo-operation-with-negative-numbers
     * @see: https://stackoverflow.com/questions/3883004/the-modulo-operation-on-negative-numbers-in-python
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] remCount = new int[K];
        remCount[0] = 1;
        int res = 0;
        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            curr += A[i];
            // surprisingly this expression is faster than the alternative
            int modK = curr -  K * Math.floorDiv(curr, K); // the real "mod" operator
            // int modK = (curr % K + K) % K; // alternative
            remCount[modK]++;
        }

        for (int val : remCount)
            res += val * (val - 1) / 2;

        return res;
    }
    
    /**
     * Solution with HashMap.
     */
    public int subarraysDivByK_var2(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            curr += A[i];
            int modK = (curr % K + K) % K; // the real "mod" operator
            // int modK = curr -  K * Math.floorDiv(curr, K); // alternative
            map.put(modK, map.getOrDefault(modK, 0) + 1);
        }

        for (int val : map.values())
            res += val * (val - 1) / 2;

        return res;
    }
    
    /**
     * Brute force solution - Not accepted(Time Limit Exceeded)
     */
    public int subarraysDivByK_var1(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + A[i - 1];
        
        int res = 0;
        for (int i = 1; i < sum.length; i++) {
            for (int j = i; j < sum.length; j++) {
                int currSum = sum[j] - sum[i - 1];
                if (currSum % K == 0)
                    res++;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK sln = new SubarraySumsDivisiblebyK();
        
        System.out.println(sln.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5)); // 7
        System.out.println(sln.subarraysDivByK(new int[] { -1, 2, 9 }, 2)); // 2
        System.out.println(sln.subarraysDivByK(new int[] { -6, 1, -5, 10 }, 9)); // 1

    }

}
