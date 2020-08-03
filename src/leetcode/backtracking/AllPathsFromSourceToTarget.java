// Given a directed acyclic graph of N nodes. Find all possible paths from node 0 to node N-1, 
// and return them in any order.
// The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  
// graph[i] is a list of all nodes j for which the edge (i, j) exists.
// See: https://leetcode.com/problems/all-paths-from-source-to-target/
// See: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    /**
     * Solution without "used" flag. We do not need to keep "used" - it is
     * pointless (the graph is directed & acyclic)
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, graph, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int currNode, int[][] graph, LinkedList<Integer> path,
            List<List<Integer>> res) {

        path.add(currNode);

        if (currNode == graph.length - 1)
            res.add(new ArrayList<>(path));

        for (int child : graph[currNode])
            dfs(child, graph, path, res);

        path.removeLast();
    }

    /**
     * Solution with "used" flag.
     */
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs1(0, graph, new LinkedList<>(), new boolean[graph.length], res);
        return res;
    }

    private void dfs1(int currNode, int[][] graph, LinkedList<Integer> path, boolean[] used,
            List<List<Integer>> res) {
        if (!used[currNode]) {
            used[currNode] = true;
            path.add(currNode);

            if (currNode == graph.length - 1)
                res.add(new ArrayList<>(path));

            for (int child : graph[currNode])
                dfs1(child, graph, path, used, res);

            path.removeLast();
            used[currNode] = false;
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget sln = new AllPathsFromSourceToTarget();
        System.out.println(sln.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
    }

}
