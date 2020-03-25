package leetcode.others;

import java.util.Arrays;

public class SortAnArray {
    /**
     * Heap Sort.
     * O(n.log(n)) time.
     * O(1) space.
     * Stable: No but can be made stable.
     */
    public int[] sortArray(int[] arr) {
        // 1. First heapify the hole tree: every parent is grater than it's children
        for (int i = 2 * arr.length - 1; i >= 0; i--)
            heapify(arr, i, arr.length);
        // When the Max Heap is created he max value is the at the beginning of the array.
        // 2. Swap the first and the last element and decrease the heap size with 1.
        // 3. Call heapify to the reduced heap.
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        
        return arr;
    }
    
    private void heapify(int[] arr, int start, int end) {
        int greater = start;
        int l = start * 2 + 1;
        int r = start * 2 + 2;
        if (l < end && r < end && arr[r] > arr[l] && arr[start] < arr[r])
            greater = r;
        else if (l < end && arr[start] < arr[l])
            greater = l;
        
        if (start != greater) {
            swap(arr, start, greater);
            heapify(arr, greater, end);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    /*
     * Quick Sort. 
     * n.log(n) time for average and base case, O(n^2) for the worst case.
     * O(1) space
     * Stable: No
     */
    public int[] sortArray_var6(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;
        int pivIndex = partition(nums, lo, hi);
        quickSort(nums, lo, pivIndex - 1);
        quickSort(nums, pivIndex + 1, hi);
    }

    /**
     * Partitions the input without an auxiliary array.
     */
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Uses additional memory for the auxiliary array.
     */
    @SuppressWarnings("unused")
    private int partitionVariant(int[] nums, int lo, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int tail = tmp.length - 1;
        int head = 0;
        int piv = nums[lo];
        for (int i = lo + 1; i <= hi; i++)
            if (nums[i] < piv)
                tmp[head++] = nums[i];
            else
                tmp[tail--] = nums[i];

        tmp[head] = piv;
        // copy back the auxiliary array to the original
        for (int i = 0; i < tmp.length; i++)
            nums[lo + i] = tmp[i];

        return head + lo;
    }
    
    /**
     * Merge Sort. 
     * n.log(n) time for worst, average and base case. 
     * O(n) space, but can be done and with O(1) space. 
     * Stable: Yes
     */
    public int[] sortArray_var5(int[] nums) {
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
     * Bubble Sort, not accepted (Time Limit Exceeded). 
     * Moreover the same time complexity as Insertion Sort or Selection Sort 
     * this algorithm seems slower in practice. 
     * O(n^2) time, O(1) space.
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
     * Binary Insertion Sort (Insertion Sort using Binary Search). 
     * O(n^2) time for the worst case(reversed order), but the number of comparisons are O(n.log(n))
     * time for average case.
     * O(1) space
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
     * Insertion sort. 
     * O(n^2) time, O(1) space.
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
     * Selection sort - initial intuitive solution. 
     * O(n^2) time , O(1) space.
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
        
//        int[] arr = new int[] {-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
//        int[] arr = new int[] {4, 10, 3, 5, 1};
//        int[] arr = new int[] {5, 2, 3, 1};
//        sln.sortArray(arr);
//        System.out.println(Arrays.toString(arr));

        int[] res = sln.sortArray(new int[] { 2, 4, 3, 1, 7, 5, 6, 1 });
        System.out.println(Arrays.toString(res));

        int[] arr1 = new int[] { 1, 5, 6, 7, 2, 3, 4, 15, 16, 17 };

        System.out.println(Arrays.toString(sln.merge(arr1, 0, 3, 6)));

        int[] arr2 = new int[] { 1, 2, 3, 6, 8, 9, 10, 5, 5, 7, 20, 30, 40 };

        System.out.println(Arrays.toString(sln.merge(arr2, 3, 6, 9)));
        System.out.println(Arrays.toString(sln.merge(arr2, 0, 1, 2)));
    }

}
