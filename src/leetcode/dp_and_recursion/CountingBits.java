// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
// calculate the number of 1's in their binary representation and return them as an array.
// See: https://leetcode.com/problems/counting-bits/

package leetcode.dp_and_recursion;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        
        int pointer = 0;
        int pow = 1;
        for (int i = 1; i < res.length; i++) {
            if (i == pow) {
               pow *= 2;
               pointer = 0;
            }
            res[i] = res[pointer] + 1;
            pointer++;
        }
        
        return res;
    }

    public static void main(String[] args) {
        CountingBits sln = new CountingBits();
        
        System.out.println(Arrays.toString(sln.countBits(2)));
        System.out.println(Arrays.toString(sln.countBits(5)));
    }

}
