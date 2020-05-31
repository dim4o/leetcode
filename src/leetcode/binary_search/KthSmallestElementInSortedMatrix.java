// Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
// find the kth smallest element in the matrix.
// Note that it is the kth smallest element in the sorted order, not the kth distinct
// See: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

package leetcode.binary_search;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    /**
     * Solution 2 - Binary Search x2
     * Time - O(n.log(n).log(N)) where N is the search space which in practice is constant
     * so in this case the time complexity is O(n.log(n)).
     * Space - O(1)
     */
    public int kthSmallest(int[][] matrix, int k) {
        return search(matrix, k, matrix[0][0], matrix[matrix.length - 1][matrix.length - 1]);
    }
    
    private int search(int[][] matrix, int k, int lo, int hi) {
        if (lo >= hi) return hi;
        
        int mid = lo + (hi - lo) / 2;
        
        int sum = 0;
        for (int[] row : matrix) {
            // One more BinarySearch can be used here to optimize this action.
            // for (int num : row)
            //     if (num <= mid) sum++;
            //     else break;
            
            int left = 0, right = row.length;
            while (left < right) {
                int m = left + (right - left) / 2;
                if (row[m] <= mid)
                    left = m + 1;
                else 
                    right = m;
            }
            sum += right;
        }
        if (sum < k)
            return search(matrix, k, mid + 1, hi);

        return search(matrix, k, lo, mid);
    }
    
    /**
     * Solution 1 - Very easy solution with Heap
     * Time complexity - O(n^2.log(k))
     * Space complexity - O(k)
     */
    public int kthSmallest_var1(int[][] matrix, int k) {
        // this is actually MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int[] matrixRow: matrix) {
            for (int num : matrixRow) {
                pq.add(num);
                // remove the max element if the size > k
                // in this way we can keep a MaxHeap with size k
                // and the top element will be the current K-th smallest
                if (pq.size() > k) pq.poll();
            }
        }

        return pq.peek();
    }
    
    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix sln = new KthSmallestElementInSortedMatrix();
        System.out.println(sln.kthSmallest(new int[][] {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        }, 8));
        
        System.out.println(sln.kthSmallest(new int[][] {
            {1, 2},
            {1, 3},
        }, 3));
        System.out.println(sln.kthSmallest(new int[][] {
            {2,6,6,7,10,14,18},
            {6,11,14,14,15,20,23},
            {11,11,17,21,25,30,30},
            {11,12,20,25,25,35,37},
            {16,16,20,29,34,35,39},
            {16,18,22,33,37,37,40},
            {17,23,26,36,38,41,42}
        }, 32));
        
        
        System.out.println(Arrays.binarySearch(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 16},  0));
    }

}
