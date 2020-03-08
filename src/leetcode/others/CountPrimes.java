// Count the number of prime numbers less than a non-negative number, n.
// See: https://leetcode.com/problems/count-primes/

package leetcode.others;

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] memo = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < memo.length - 1; i++)
            if (!memo[i]) {
                for (int j = i; (long)i * j < memo.length; j++)
                    memo[i * j] = true;
                count++;
            }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes sln = new CountPrimes();

        System.out.println(sln.countPrimes(1) == 0); // 0
        System.out.println(sln.countPrimes(2) == 0); // 0
        System.out.println(sln.countPrimes(3) == 1); // 1
        System.out.println(sln.countPrimes(10) == 4); // 4
        System.out.println(sln.countPrimes(11) == 4); // 4
        System.out.println(sln.countPrimes(20) == 8); // 8
        System.out.println(sln.countPrimes(23) == 8); // 8
        System.out.println(sln.countPrimes(499979) == 41537); // 41537
    }

}
