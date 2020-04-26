// Given a positive integer num, write a function which returns True if num is a perfect square else False.
// Note: Do not use any built-in library function such as sqrt.
// See: https://leetcode.com/problems/valid-perfect-square/

package leetcode.math;

public class ValidPerfectSquare {
    // Binary Search solution.
    // O(log(n)) time
    public boolean isPerfectSquare(int num) {
        return binarySearch(num, 0, num/2 + 1);
    }
    
    private boolean binarySearch(int num, int l, int r) {
        if (l > r)
            return false;
        
        int mid = l + (r - l) / 2;
        long sqMid = (long)mid * mid;
        if (sqMid == num)
            return true;
        else if (sqMid > num || sqMid < 0)
            return binarySearch(num, l, mid - 1);
        
        return binarySearch(num, mid + 1, r);
    }
    
    // Bruteforce solution - accepted but very slow.
    // O(n) time
    public boolean isPerfectSquare_var2(int num) {
        if (num == 1 || num == 4 || num == 9 || num == 16 || num == 5)
            return true;

        for (int i = 1; i <= num / 4; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    // Bruteforce solution - not accepted(TLE).
    // O(n) time
    public boolean isPerfectSquare_var1(int num) {
        if (num == 1)
            return true;

        for (int i = 1; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare sln = new ValidPerfectSquare();
        System.out.println(sln.isPerfectSquare(1));
        System.out.println(sln.isPerfectSquare(808201));
        System.out.println(sln.isPerfectSquare(223729));
        System.out.println(sln.isPerfectSquare(2147483647)); 
        System.out.println(sln.isPerfectSquare(2147395600)); 

    }

}
