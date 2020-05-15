// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
// some elements appear twice and others appear once.
// Find all the elements of [1, n] inclusive that do not appear in this array.
// Could you do it without extra space and in O(n) runtime? You may assume 
// the returned list does not count as extra space.
// See: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

package leetcode.array_and_hashtable;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    
    // TODO: Could you do it without extra space and in O(n) runtime?
    
    /**
     * Solution 1 - initial solution, O(n) time O(n) space.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            index[nums[i] - 1] = nums[i];

        for (int i = 0; i < index.length; i++)
            if (index[i] == 0) res.add(i + 1);

        return res;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray sln = new FindAllNumbersDisappearedInAnArray();
        System.out.println(sln.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
        System.out.println(sln.findDisappearedNumbers(new int[] {1, 1}));
        System.out.println(sln.findDisappearedNumbers(new int[] {1}));
        System.out.println(sln.findDisappearedNumbers(new int[] {}));

    }

}
