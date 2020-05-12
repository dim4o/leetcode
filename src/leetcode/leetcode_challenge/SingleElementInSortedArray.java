// You are given a sorted array consisting of only integers where every element appears exactly twice, 
// except for one element which appears exactly once. Find this single element that appears only once.
// See: https://leetcode.com/problems/single-element-in-a-sorted-array/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
// See: https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/627867/Java-Concise-Binary-Search

package leetcode.leetcode_challenge;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return nums[binarySearch(nums, 0, nums.length - 1)];
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l > r) return r;
        
        int mid = l + (r - l)/2;
        if (mid == 0 || mid == nums.length - 1) return mid;
        
        if (nums[mid] == nums[mid - 1] && mid % 2 == 0 || nums[mid] == nums[mid + 1] && mid % 2 == 1)
            return binarySearch(nums, l, mid - 1);
        else if (nums[mid] == nums[mid - 1] && mid % 2 == 1 || nums[mid] == nums[mid + 1] && mid % 2 == 0)
            return binarySearch(nums, mid + 1, r);

        return mid;
    }

    public static void main(String[] args) {
        SingleElementInSortedArray sln = new SingleElementInSortedArray();
        System.out.println(sln.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
        System.out.println(sln.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
        System.out.println(sln.singleNonDuplicate(new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5 }));
        System.out.println(sln.singleNonDuplicate(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5 }));
    }

}
