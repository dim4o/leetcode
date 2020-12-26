// Given a string s and an array of integers cost where cost[i] is the cost of deleting the 
// i-th character in s.
// Return the minimum cost of deletions such that there are no two identical letters next to each other.
// Notice that you will delete the chosen characters at the same time, in other words, 
// after deleting a character, the costs of deleting other characters will not change.
// See: https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/

package leetcode.others;

public class MinimumDeletionCostToAvoidRepeatingLetters {

    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                int min = cost[i - 1];
                int sum = cost[i - 1];
                while (i < arr.length && arr[i] == arr[i - 1]) {
                    min = Math.max(min, cost[i]);
                    sum += cost[i++];
                }
                res += (sum - min);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumDeletionCostToAvoidRepeatingLetters sln = new MinimumDeletionCostToAvoidRepeatingLetters();

        System.out.println(sln.minCost("abaac", new int[] { 1, 2, 3, 4, 5 })); // 3
        System.out.println(sln.minCost("abc", new int[] { 1, 2, 3 })); // 0
        System.out.println(sln.minCost("aabaa", new int[] { 1, 2, 3, 4, 1 })); // 2
    }

}
