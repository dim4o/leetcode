// Given an integer array arr, count element x such that x + 1 is also in arr.
// If there're duplicates in arr, count them separately.
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/

package leetcode.leetcode_challenge;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public int countElements(int[] arr) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int el : arr) set.add(el);

        for (int el : arr)
            if (set.contains(el + 1)) count++;

        return count;
    }

    public static void main(String[] args) {
        CountingElements sln = new CountingElements();
        
        System.out.println(sln.countElements(new int[] { 1, 2, 3 }));
        System.out.println(sln.countElements(new int[] { 1, 1, 3, 3, 5, 5, 7, 7 }));
        System.out.println(sln.countElements(new int[] { 1, 3, 2, 3, 5, 0 }));
        System.out.println(sln.countElements(new int[] { 1, 1, 2, 2 }));
    }

}
