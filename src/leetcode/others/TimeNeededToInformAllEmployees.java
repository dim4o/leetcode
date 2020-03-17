// A company has n employees with a unique ID for each employee from 0 to n - 1. 
// The head of the company has is the one with headID.
// Each employee has one direct manager given in the manager array where manager[i] 
// is the direct manager of the i-th employee, manager[headID] = -1. 
// Also it's guaranteed that the subordination relationships have a tree structure.
// The head of the company wants to inform all the employees of the company of 
// an urgent piece of news. He will inform his direct subordinates and they 
// will inform their subordinates and so on until all employees know about the urgent news.
// The i-th employee needs informTime[i] minutes to inform all of his direct subordinates 
// (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).
// Return the number of minutes needed to inform all the employees about the urgent news.
// See: https://leetcode.com/problems/time-needed-to-inform-all-employees/

package leetcode.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] time = new int[informTime.length];
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < manager.length; i++)
            tree.computeIfAbsent(manager[i], k -> new LinkedList<>()).add(i);
        
        int maxTime = 0;
        Queue<Integer> q = new LinkedList<>(tree.get(-1));

        while (!q.isEmpty()) {
            int currManager = q.poll();
            List<Integer> subords = tree.getOrDefault(currManager, new LinkedList<>());
            for (Integer subordinate : subords) {
                time[subordinate] = informTime[currManager] + time[manager[subordinate]];
                maxTime = Math.max(maxTime, time[subordinate]);
                q.add(subordinate);
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        TimeNeededToInformAllEmployees sln = new TimeNeededToInformAllEmployees();

        System.out.println(sln.numOfMinutes(1, 0, new int[] { -1 }, new int[] { 0 })); // 0

        System.out.println(sln.numOfMinutes(6, 2, new int[] { 2, 2, -1, 2, 2, 2 },
                new int[] { 0, 0, 1, 0, 0, 0 })); // 1

        System.out.println(sln.numOfMinutes(7, 6, new int[] { 1, 2, 3, 4, 5, 6, -1 },
                new int[] { 0, 6, 5, 4, 3, 2, 1 })); // 21

        System.out.println(
                sln.numOfMinutes(15, 0, new int[] { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 },
                        new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 })); // 3

        System.out.println(
                sln.numOfMinutes(4, 2, new int[] { 3, 3, -1, 2 }, new int[] { 0, 0, 162, 914 })); // 1076
    }

}
