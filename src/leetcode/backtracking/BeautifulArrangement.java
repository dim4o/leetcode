// Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
//   - The number at the ith position is divisible by i.
//   - i is divisible by the number at the ith position.
// Now given N, how many beautiful arrangements can you construct?
// See: https://leetcode.com/problems/beautiful-arrangement/

package leetcode.backtracking;

public class BeautifulArrangement {
    int counter = 0;

    public int countArrangement(int N) {
        int[] arr = new int[N];
        boolean[] used = new boolean[N];
        perm(arr, used, 0);

        return counter;
    }

    private void perm(int[] arr, boolean[] used, int pos) {
        if (pos == arr.length) {
            counter++;
            // System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i] && ((i + 1) % (pos + 1) == 0 || (pos + 1) % (i + 1) == 0)) {
                used[i] = true;
                arr[i] = pos + 1;
                perm(arr, used, pos + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement sln = new BeautifulArrangement();
        System.out.println(sln.countArrangement(2));
    }

}
