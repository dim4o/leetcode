// Given an array of citations (each citation is a non-negative integer) of a researcher, 
// write a function to compute the researcher's h-index.
// According to the definition of h-index on Wikipedia: 
//   "A scientist has index h if h of his/her N papers have at least h citations each, 
//    and the other N − h papers have no more than h citations each.
// See: https://leetcode.com/problems/h-index/
// See: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class HIndex {
    /**
     * Time complexity: O(n.log(n)) - can be decreased to O(n) with Counting Sort.
     * Space complexity: O(1)
     */
    public int hIndex(int[] citations) {
        int N = citations.length;
        int h = 0;

        Arrays.sort(citations);

        for (int i = 0; i < N; i++) {
            if (citations[i] >= N - i)
                h = Math.max(h, N - i);
        }

        return h;
    }

    public static void main(String[] args) {
        HIndex sln = new HIndex();

        System.out.println(sln.hIndex(new int[] { 3, 0, 6, 1, 5 })); // 3
    }

}
