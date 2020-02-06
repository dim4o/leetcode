// Given a 32-bit signed integer, reverse digits of an integer.
// See: https://leetcode.com/problems/reverse-integer/

package com.leetcode.math;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res  = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }
    
    public int reverse_1(int x) {
        Queue<Integer> reversedQ = new LinkedList<>();
        while (x != 0) {
            reversedQ.add(x % 10);
            x = x / 10;
        }
        int pow = (int) Math.pow(10, reversedQ.size() - 1);
        long res = 0;

        while (!reversedQ.isEmpty()) {
            res += (long)reversedQ.poll() * pow;
            pow /= 10;
            
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        ReverseInteger sln = new ReverseInteger();
        
//        System.out.println(sln.reverse(-1234));
//        System.out.println(sln.reverse(0));
//        System.out.println(sln.reverse(123));
//        System.out.println(sln.reverse(120));
//
//        System.out.println(sln.reverse(2147483647));
//        System.out.println(sln.reverse(-2147483648));
//        System.out.println(sln.reverse(563847412));
        System.out.println(sln.reverse(1534236469));
    }   
}
