// Given a fixed-length integer array arr, duplicate each occurrence of zero, 
// shifting the remaining elements to the right.
// Note that elements beyond the length of the original array are not written. 
// Do the above modifications to the input array in place and do not return anything.
// See: https://leetcode.com/problems/duplicate-zeros/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class DuplicateZeros {
    /*
     * Linear solution
     * Uses an additional space - not memory optimal but fast
     * TODO: Add in-place solution
     */
    public void duplicateZeros(int[] arr) {
        int[] help = new int[arr.length];
        int p = 0, i = 0;
        
        while (p < arr.length) {
            if (arr[i] != 0) 
                help[p++] = arr[i];
            else 
                p += 2;
            i++;
        }
        
        System.arraycopy(help, 0, arr, 0, arr.length);
    }
    
    public static void main(String[] args) {
        DuplicateZeros sln = new DuplicateZeros();
        int[] arr = {1,0,2,3,0,4,5,0};
        
        sln.duplicateZeros(arr);
        
        System.out.println(Arrays.toString(arr));

    }

}
