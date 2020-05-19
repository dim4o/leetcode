// Given a sorted array and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.
// You may assume no duplicates in the array.
// See: https://leetcode.com/problems/search-insert-position/
// See: https://leetcode.com/problems/search-insert-position/discuss/640617/Java-Simple-Binary-Search

package leetcode.binary_search;

public class SearchInsertPosition {
    /**
     * Simple Binary Search solution
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r)
            return l;
        int mid = l + (r - l) / 2;
        if (target < nums[mid]) 
            return binarySearch(nums, target, l, mid - 1);
        else if(target > nums[mid])
            return binarySearch(nums, target, mid + 1, r);
        return mid;
    }
    
    public static void main(String[] args) {
        SearchInsertPosition sln = new SearchInsertPosition();
        System.out.println(sln.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(sln.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(sln.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(sln.searchInsert(new int[] {1,3,5,6}, 0));
    }

}
