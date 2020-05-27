// Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
// Each person may dislike some other people, and they should not go into the same group. 
// Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b 
// into the same group.
// Return true if and only if it is possible to split everyone into two groups in this way.
// See: https://leetcode.com/problems/possible-bipartition/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/

package leetcode.leetcode_challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PossibleBipartition {
    /**
     * The problem is connected to Bipartite graph detection problem.
     * 
     * @see: https://www.geeksforgeeks.org/bipartite-graph/
     */
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (int[] dislike : dislikes) {
            graph.computeIfAbsent(dislike[0], k -> new LinkedList<>()).add(dislike[1]);
            graph.computeIfAbsent(dislike[1], k -> new LinkedList<>()).add(dislike[0]);
        }

        int[] colored = new int[N];
        for (int key : graph.keySet())
            if (colored[key - 1] == 0 && !bipart(N, dislikes, key, 1, colored))
                return false;

        return true;
    }

    private boolean bipart(int N, int[][] dislakes, int key, int color, int[] colored) {
        colored[key - 1] = color;
        for (int neighbor : graph.get(key))
            if (colored[neighbor - 1] == 0)
                bipart(N, dislakes, neighbor, -color, colored);
            else if (colored[neighbor - 1] == color)
                return false;

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new PossibleBipartition().possibleBipartition(5,
                new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }));

        System.out.println(new PossibleBipartition().possibleBipartition(3,
                new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));

        System.out.println(new PossibleBipartition().possibleBipartition(4,
                new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } }));

        System.out.println(new PossibleBipartition().possibleBipartition(5,
                new int[][] { { 1, 2 }, { 3, 4 }, { 4, 5 }, { 3, 5 } }));

    }

}
