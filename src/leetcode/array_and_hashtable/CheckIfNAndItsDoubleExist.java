// Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
//
// More formally check if there exists two indices i and j such that:
//
//  - i != j
//  - 0 <= i, j < arr.length
//  - arr[i] == 2 * arr[j]
// See: https://leetcode.com/problems/check-if-n-and-its-double-exist/
        
package leetcode.array_and_hashtable;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> memo = new HashSet<>();
        
        for (Integer num : arr) {
            if (memo.contains(num))
                return true;
            
            memo.add(num * 2);
            if (num % 2 == 0)
                memo.add(num / 2);
        }
        return false;
    }

}
