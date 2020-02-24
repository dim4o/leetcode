// Given n and k, return the kth permutation sequence.
// See: https://leetcode.com/problems/permutation-sequence/

package leetcode.backtracking;

import java.util.Arrays;

public class PermutationSequence {

    private int counter = 0;
    private int[] kthPerm = null;

    public String getPermutation(int n, int k) {
        perm(new int[n], new boolean[n], 0, k);
        return Arrays.toString(kthPerm).replaceAll("\\[|\\]|,|\\s", "");
    }

    private void perm(int[] nums, boolean[] used, int pos, int k) {
        if (pos == nums.length) {
            if (++counter == k)
                kthPerm = nums.clone();
        } else if (counter < k)
            for (int i = 0; i < nums.length; i++)
                if (!used[i]) {
                    used[i] = true;
                    nums[pos] = i + 1;
                    perm(nums, used, pos + 1, k);
                    used[i] = false;
                }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 3));
        System.out.println(new PermutationSequence().getPermutation(4, 9));
    }

}
