package leetcode.others;

import java.util.Arrays;

public class SortAnArray {
    /**
     * Merge Sort. n.log(n) time for worst, average and base case. O(n) space, but
     * can be done and with O(1) space. Stable: Yes
     */
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (lo == hi)
            return nums;

        nums = mergeSort(nums, lo, mid);
        nums = mergeSort(nums, mid + 1, hi);

        return merge(nums, lo, mid, hi);
    }

    /**
     * This is the tricky part of the algorithm.
     */
    private int[] merge(int[] nums, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int l = lo, r = mid + 1;
        int i = 0;
        while (l <= mid && r <= hi)
            if (nums[l] < nums[r])
                tmp[i++] = nums[l++];
            else
                tmp[i++] = nums[r++];
        // copy the rest of the left part
        for (int j = l; j <= mid; j++)
            tmp[i++] = nums[j];
        // copy the rest of the right part
        for (int j = r; j <= hi; j++)
            tmp[i++] = nums[j];
        // copy the merged part to the original array
        for (int j = lo; j <= hi; j++)
            nums[j] = tmp[j - lo];

        return nums;
    }

    /**
     * Bubble Sort, not accepted (Time Limit Exceeded). Moreover the same time
     * complexity as Insertion Sort or Selection Sort this algorithm seems slower in
     * practice. O(n^2) time, O(1) space
     */
    public int[] sortArray_var4(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    sorted = false;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (sorted)
                break;
        }

        return nums;
    }

    /**
     * Binary Insertion Sort (Insertion Sort using Binary Search). O(n^2) time for
     * the worst case(reversed order), but the number of comparisons are O(n.log(n))
     * time for average case, O(1) space.
     */
    public int[] sortArray_var3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // 1. Use custom method:
            int idxToInset = binarySearch(nums, 0, i, curr);
            // 2. Use library method:
            // int idxToInset = Arrays.binarySearch(nums, 0, i, curr);
            // idxToInset = idxToInset >= 0 ? idxToInset : Math.abs(idxToInset) - 1;

            for (int j = i; j > idxToInset; j--)
                nums[j] = nums[j - 1];
            nums[idxToInset] = curr;
        }

        return nums;
    }

    /**
     * @param from - inclusive
     * @param to   - exclusive
     * @return - index of the lower bound
     */
    private int binarySearch(int[] arr, int l, int r, int target) {
        if (l >= r)
            return r;

        int mid = (l + r - 1) / 2;
        if (arr[mid] == target)
            return mid;
        else if (target < arr[mid])
            return binarySearch(arr, l, mid, target);
        else
            return binarySearch(arr, mid + 1, r, target);
    }

    /**
     * Insertion sort. O(n^2) time, O(1) space.
     */
    public int[] sortArray_var2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Move elements of arr[0..i-1], that are
            // greater than curr, to one position ahead
            int j = i - 1;
            while (j >= 0 && nums[j] > curr)
                nums[j + 1] = nums[j--];

            nums[j + 1] = curr;
        }

        return nums;
    }

    /**
     * Selection sort - initial intuitive solution. O(n^2) time , O(1) space.
     */
    public int[] sortArray_var1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = i;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[curr])
                    curr = j;

            int tmp = nums[curr];
            nums[curr] = nums[i];
            nums[i] = tmp;
        }

        return nums;
    }

    public static void main(String[] args) {
        SortAnArray sln = new SortAnArray();

        int[] res = sln.sortArray(new int[] { 2, 4, 3, 1, 7, 5, 6, 1 });
        System.out.println(Arrays.toString(res));

        int[] arr1 = new int[] { 1, 5, 6, 7, 2, 3, 4, 15, 16, 17 };

        System.out.println(Arrays.toString(sln.merge(arr1, 0, 3, 6)));

        int[] arr2 = new int[] { 1, 2, 3, 6, 8, 9, 10, 5, 5, 7, 20, 30, 40 };

        System.out.println(Arrays.toString(sln.merge(arr2, 3, 6, 9)));
        System.out.println(Arrays.toString(sln.merge(arr2, 0, 1, 2)));
    }

}
