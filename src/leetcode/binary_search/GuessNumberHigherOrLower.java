// We are playing the Guess Game. The game is as follows:
// I pick a number from 1 to n. You have to guess which number I picked.
// Every time you guess wrong, I'll tell you whether the number is higher or lower.
// You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//   - -1 : My number is lower
//   - 1 : My number is higher
//   - 0 : Congrats! You got it!

package leetcode.binary_search;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        return binarySearch(0, n);
    }
    
    private int binarySearch(int lo, int hi) {
        if (lo > hi) 
            return hi;
        
        int mid = lo + (hi - lo)/2;
        if (guess(mid) == -1)
            return binarySearch(lo, mid - 1);
        else if (guess(mid) == 1)
            return binarySearch(mid + 1, hi);
        
        return mid;
    }
    
    /** 
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return       -1 if num is lower than the guess number
     *                1 if num is higher than the guess number
     *               otherwise return 0
     */
    private int guess(int guessNum) {
        int num = 6;
        if (guessNum < num)
            return 1;
        else if (guessNum > num) 
            return -1;
        return 0;
    }
    
    
    public static void main(String[] args) {
        GuessNumberHigherOrLower sln = new GuessNumberHigherOrLower();
        System.out.println(sln.guessNumber(10));
    }

}
