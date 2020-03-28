// A string S of lowercase letters is given. We want to partition this string 
// into as many parts as possible so that each letter appears in at most one part, 
// and return a list of integers representing the size of these parts.
// See: https://leetcode.com/problems/partition-labels/

package leetcode.others;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    /**
     * The initial solution.
     * TODO: Write faster solution. There is a smarter approach
     */
    public List<Integer> partitionLabels(String S) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++)
            map.computeIfAbsent(S.charAt(i), k -> new ArrayList<>()).add(i);

        int[][] intervals = new int[map.size()][];
        int i = 0;
        for (List<Integer> v : map.values())
            intervals[i++] = new int[] { v.get(0), v.get(v.size() - 1) };

        List<int[]> merged = merge(intervals);
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < merged.size(); j++)
            res.add(merged.get(j)[1] - merged.get(j)[0] + 1);

        return res;
    }

    // @see: leetcode.others.MergeIntervals solution
    public List<int[]> merge(int[][] intervals) {
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] interval : intervals)
            if (ans.isEmpty() || ans.getLast()[1] < interval[0])
                ans.add(interval);
            else
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels sln = new PartitionLabels();

        System.out.println(sln.partitionLabels("ababcbacadefegdehijhklij"));
    }

}
