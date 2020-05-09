// Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
// If there aren't two consecutive 1's, return 0.
// See: https://leetcode.com/problems/binary-gap/

package leetcode.others;

public class BinaryGap {
    /**
     * Fast implementation.
     */
    public int binaryGap(int N) {
        int mask = 1,  max = 0, dist = 0;
        while (N > mask) {
            if ((mask & N) >= 1) {
                max = Math.max(max, dist);
                dist = 1;
            } else if (dist > 0)
                dist++;
            mask <<= 1;
        }
        return max;
    }
    
    /**
     * Easy and lazy implementation.
     */
    public int binaryGap_var1(int N) {
        char[] arr = Integer.toBinaryString(N).toCharArray();
        int max = 0;
        int dist = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                max = Math.max(max, dist);
                dist = 1;
            } else if (dist > 0)
                dist++;
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryGap sln = new BinaryGap();
        System.out.println(sln.binaryGap(22));
        System.out.println(sln.binaryGap(5));
        System.out.println(sln.binaryGap(6));
        System.out.println(sln.binaryGap(8));
        
//        System.out.println(22 & 2);
    }
}
