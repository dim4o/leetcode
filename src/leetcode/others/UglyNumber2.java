// Write a program to find the n-th ugly number.
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
// See: https://leetcode.com/problems/ugly-number-ii/

package leetcode.others;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class UglyNumber2 {
    
    /**
     * Priority Queue Solution.
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        
        for (int i = 1; i < n; i++) {
            long curr = pq.poll();
            
            pq.add(curr * 2L);
            pq.add(curr * 3L);
            pq.add(curr * 5L);
            while(pq.peek() == curr) pq.remove(); 
        }

        return pq.poll().intValue();
    }
    
    /**
     * TreeSet Solution.
     */
    public int nthUglyNumber_var1(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        
        for (int i = 1; i < n; i++) {
            long curr = set.pollFirst();
            set.add(curr * 2L);
            set.add(curr * 3L);
            set.add(curr * 5L);
        }

        return set.pollFirst().intValue();
    }
    
    public static void main(String[] args) {
        UglyNumber2 sln = new UglyNumber2();
        System.out.println(sln.nthUglyNumber(10)); // 12
        System.out.println(sln.nthUglyNumber(8));  // 9
        System.out.println(sln.nthUglyNumber(14)); // 20
        System.out.println(sln.nthUglyNumber(16)); // 25
        System.out.println(sln.nthUglyNumber(27)); // 64
    }

}
