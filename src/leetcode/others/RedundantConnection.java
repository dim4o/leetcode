// Redundant Connection
// See: https://leetcode.com/problems/redundant-connection/

package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedundantConnection {
    // Slow but intuitive solution
    public int[] findRedundantConnection(int[][] edges) {
        List<Set<Integer>> sets = new ArrayList<>();
        int[] ans = null;
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            int sIdx = -1, eIdx = -1;
            for (int i = 0; i < sets.size(); i++) {
                if (sets.get(i).contains(start)) {
                    sIdx = i;
                }
                if (sets.get(i).contains(end)) {
                    eIdx = i;
                }
            }

            if (sIdx == -1 && eIdx == -1) {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(start);
                newSet.add(end);
                sets.add(newSet);
            } else if (sIdx == -1 && eIdx != -1) {
                sets.get(eIdx).add(start);
            } else if (sIdx != -1 && eIdx == -1) {
                sets.get(sIdx).add(end);
            } else if (sIdx != eIdx) {
                sets.get(sIdx).addAll(sets.get(eIdx));
                sets.remove(eIdx);
            } else {
                ans = edge;
            }
        }

        return ans;
    }

    // Non-working version (Time Limit) of Union-Find implementation
    // TODO: Add a correct version
    public int[] findRedundantConnection_DS(int[][] edges) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] ans = null;
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            Integer rootStart = find(start, map);
            Integer rootEnd = find(end, map);

            if (rootStart == null && rootEnd == null) {
                map.put(start, null);
                map.put(end, start);
            } else if (rootStart != null && rootEnd == null) {
                map.put(end, rootStart);
            } else if (rootStart == null && rootEnd != null) {
                map.put(start, rootEnd);
            } else if (rootStart != rootEnd) {
                map.put(rootEnd, rootStart);
            } else if (rootStart == rootEnd) {
                ans = edge;
            }
        }

//        System.out.println(map);

        return ans;
    }

    private Integer find(int node, Map<Integer, Integer> map) {
        if (!map.containsKey(node))
            return null;
        int root = node;
        while (map.get(root) != null) {
            root = map.get(root);
        }

        return root;
    }

    public static void main(String[] args) {
        RedundantConnection sln = new RedundantConnection();
        System.out.println(Arrays.toString(
                sln.findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } })));

        System.out.println(Arrays.toString(sln.findRedundantConnection(
                new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } })));

        System.out.println(Arrays.toString(sln.findRedundantConnection(
                new int[][] { { 3, 4 }, { 1, 2 }, { 2, 4 }, { 3, 5 }, { 2, 5 } })));

        System.out.println(Arrays.toString(sln.findRedundantConnection(new int[][] { { 16, 25 },
                { 7, 9 }, { 3, 24 }, { 10, 20 }, { 15, 24 }, { 2, 8 }, { 19, 21 }, { 2, 15 },
                { 13, 20 }, { 5, 21 }, { 7, 11 }, { 6, 23 }, { 7, 16 }, { 1, 8 }, { 17, 20 },
                { 4, 19 }, { 11, 22 }, { 5, 11 }, { 1, 16 }, { 14, 20 }, { 1, 4 }, { 22, 23 },
                { 12, 20 }, { 15, 18 }, { 12, 16 } })));
        
    }

}
