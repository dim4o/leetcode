// You are a product manager and currently leading a team to develop a new product. 
// Unfortunately, the latest version of your product fails the quality check. 
// Since each version is developed based on the previous version, all the versions after 
// a bad version are also bad.
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
// which causes all the following ones to be bad.
// You are given an API bool isBadVersion(version) which will return whether version is bad. 
// Implement a function to find the first bad version. 
// You should minimize the number of calls to the API.
// See: https://leetcode.com/problems/first-bad-version/

package leetcode.others;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return (int) binarySearch(1, n);
    }

    /**
     * We need to use long instead int here because l + r can exceed the maximum int
     * value
     */
    private long binarySearch(long l, long r) {
        if (l > r)
            return l;
        // Here is the trap (l + r) > Integer.MAX_VALUE is possible
        // Another approach is to use:
        // int mid = l + (r - l)/2
        long mid = (l + r) / 2;
        if (isBadVersion((int) mid))
            return binarySearch(l, mid - 1);
        else
            return binarySearch(mid + 1, r);
    }

    // The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static void main(String[] args) {
        FirstBadVersion sln = new FirstBadVersion();
        System.out.println(sln.firstBadVersion(2126753390));
    }

}
