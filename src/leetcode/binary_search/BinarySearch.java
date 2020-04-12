// Given a sorted (in ascending order) integer array nums of n elements and a target value, 
// write a function to search target in nums. If target exists, 
// then return its index, otherwise return -1.
// See: https://leetcode.com/problems/binary-search/

package leetcode.binary_search;

public class BinarySearch {
    // Recursive solution
    // Note: after the iterative solution the recursive was trivial
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);
    }

    public int bs(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int guessIndex = (start + end) / 2;
        if (nums[guessIndex] == target) {
            return guessIndex;
        } else if (nums[guessIndex] < target) {
            return bs(nums, target, guessIndex + 1, end);
        } else {
            return bs(nums, target, start, guessIndex - 1);
        }
    }

    // Iterative approach
    public int search1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int guessIndex = (start + end) / 2;

            if (nums[guessIndex] == target) {
                return guessIndex;
            } else if (nums[guessIndex] < target) {
                start = guessIndex + 1;
            } else {
                end = guessIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch sln = new BinarySearch();

        System.out.println(sln.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
        System.out.println(sln.search(new int[] { -1, 0, 3, 5, 9, 12 }, -1));
        System.out.println(sln.search(new int[] { -1, 0, 3, 5, 9, 12 }, 12));
        System.out.println(sln.search(new int[] { -1, 0, 3, 5, 9, 12 }, 20));
        System.out.println(sln.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
        System.out.println(sln.search(new int[] { 5 }, 5));
    }

}
