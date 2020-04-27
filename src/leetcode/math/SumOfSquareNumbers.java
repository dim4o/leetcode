// Given a non-negative integer c, your task is to decide whether there're 
// two integers a and b such that a2 + b2 = c.
// See: https://leetcode.com/problems/sum-of-square-numbers/

package leetcode.math;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            double sqrt = Math.sqrt(c - i * i);
            if (sqrt == (int)sqrt)
                return true;
        }
        return false;
    }
    
    public boolean judgeSquareSum_var1(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            for (int j = 0; j <= Math.sqrt(c); j++) {
                if (i * i + j*j == c) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SumOfSquareNumbers sln = new SumOfSquareNumbers();
        System.out.println(sln.judgeSquareSum(15));

    }

}
