// For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  
// For example, if X = 1231, then the array form is [1,2,3,1].
// Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
// See: https://leetcode.com/problems/add-to-array-form-of-integer/

package leetcode.array_and_hashtable;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    /**
     * Solution 2 - Optimized version of the initial solution.
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;

        int i = A.length;
        while (--i >= 0 || K > 0) {
            int curr = i >= 0 ? (A[i] + K%10 + carry) : K%10 + carry;
            K = K/10;
            carry = curr / 10;
            list.addFirst(curr % 10);
        }

        if (carry > 0)
            list.addFirst(carry);
        
        return list;
    }

    /**
     * Solution 1 - Initial solution.
     */
    public List<Integer> addToArrayForm_var1(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int rem = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int curr = (A[i] + K%10 + rem);
            K = K/10;
            rem = curr / 10;
            curr = curr % 10;
            list.addFirst(curr);
        }

        while (K > 0) {
            int curr = K%10 + rem;
            K = K / 10;
            rem = curr / 10;
            curr = curr % 10;
            list.addFirst(curr);
        }

        if (rem > 0)
            list.addFirst(rem);
        
        return list;
    }
    
    public static void main(String[] args) {
        AddToArrayFormOfInteger sln = new AddToArrayFormOfInteger();
        
        System.out.println(sln.addToArrayForm(new int[] {1,2,0,0}, 34));
        System.out.println(sln.addToArrayForm(new int[] {2,7,4}, 181));
        System.out.println(sln.addToArrayForm(new int[] {2,1,5}, 806));
        System.out.println(sln.addToArrayForm(new int[] {9,9,9,9,9,9,9,9,9,9}, 1));
        
        System.out.println(sln.addToArrayForm(new int[] {0}, 23));
        System.out.println(sln.addToArrayForm(new int[] {1,8}, 9988));

    }

}
