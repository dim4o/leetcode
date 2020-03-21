// On the first row, we write a 0. Now in every subsequent row, we look at the previous 
// row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
// Given row N and index K, return the K-th indexed symbol in row N. 
// (The values of K are 1-indexed.) (1 indexed).
// See: https://leetcode.com/problems/k-th-symbol-in-grammar/

// Binary Search approach: https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/531440/Simple-Binary-Search

package leetcode.others;

public class KthSymbolInGrammar {
    /**
     * Very elegant solution based on one simple observation: The rows can be represented as a tree. 
     */
    public int kthGrammar(int N, int K) {
        if (N == 0) return 0;
        
        int prev = kthGrammar(N - 1, (K - 1) / 2 + 1);
        
        if (K % 2 == 0 && prev == 0 || K % 2 == 1 && prev == 1)
            return 1;
        
        return 0;
    }
    
    /**
     * This solution works but seems difficult and anti-intuitive
     */
    public int kthGrammar_var1(int N, int K) {
        if ((N == 1 || N == 2) && K == 1)
            return 0;
        if (N == 2 && K == 2)
            return 1;

        int L = 2 << (N - 2);

        if (K <= L / 2)
            return kthGrammar_var1(N - 1, K);

        if (K > 3 * L / 4)
            return kthGrammar_var1(N - 2, K - 3 * L / 4);

        return kthGrammar_var1(N - 1, K - L / 4);
    }
   

    public static void main(String[] args) {
        KthSymbolInGrammar sln = new KthSymbolInGrammar();
        System.out.println(sln.kthGrammar(1, 1));
        System.out.println(sln.kthGrammar(4, 5));
        System.out.println(sln.kthGrammar(3, 2));

    }

}
