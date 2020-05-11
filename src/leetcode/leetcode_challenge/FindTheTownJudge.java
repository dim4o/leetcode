// In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
// If the town judge exists, then:
//   1. The town judge trusts nobody.
//   2. Everybody (except for the town judge) trusts the town judge.
//   3. There is exactly one person that satisfies properties 1 and 2.
// You are given trust, an array of pairs trust[i] = [a, b] representing 
// that the person labeled a trusts the person labelled b.
// If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
// See: https://leetcode.com/problems/find-the-town-judge/
// https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

package leetcode.leetcode_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {
        if (N == 1) return 1;
        
        List<Integer> candidates = new LinkedList<>();
        int[] trustCount = new int[N + 1];
        Set<Integer> set = new HashSet<>();
        for (int[] pair : trust) {
            set.add(pair[0]);
            if (++trustCount[pair[1]] == N - 1)
                candidates.add(pair[1]);
        }
        
        for (int candidate : candidates)
            if (!set.contains(candidate)) 
                return candidate;
        
        return -1;
    }
    
    public int findJudge_var1(int N, int[][] trust) {
        Set<Integer> all = new HashSet<>();
        for (int i = 0; i < N; i++)
            all.add(i + 1);
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : trust) {
            map.computeIfAbsent(pair[0], k -> new HashSet<>()).add(pair[1]);
            all.remove(pair[0]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i : all) {

            boolean flag = true;
            for (int key : map.keySet()) {
                if (!map.get(key).contains(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(i);
            if (res.size() > 1) return -1;
        }

        return !res.isEmpty() ? res.get(0) : -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge sln = new FindTheTownJudge();
        System.out.println(
                sln.findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
        System.out.println(sln.findJudge(3, new int[][] { { 1, 2, }, { 2, 3 } }));
        
        System.out.println(sln.findJudge(1, new int[][] { }));
    }

}
