// An array is monotonic if it is either monotone increasing or monotone decreasing.
// An array A is monotone increasing if for all i <= j, A[i] <= A[j].  
// An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
// Return true if and only if the given array A is monotonic.
// See: https://leetcode.com/problems/monotonic-array/

package leetcode.array_and_hashtable;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A.length < 3)
            return true;
        Boolean incr = null;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1] && incr == null)
                incr = true;
            else if (A[i] > A[i + 1] && incr == null)
                incr = false;
            else if (A[i] < A[i + 1] && !incr || A[i] > A[i + 1] && incr)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray sln = new MonotonicArray();

        System.out.println(sln.isMonotonic(new int[] { 1, 1, 1, 2 })); // true
        System.out.println(sln.isMonotonic(new int[] { 1, 1, 1, 2, 1 })); // false
        System.out.println(sln.isMonotonic(new int[] { 2, 2, 2, 1 })); // true
        System.out.println(sln.isMonotonic(new int[] { 2, 2, 2, 1, 1, 2 })); // false
    }

}
