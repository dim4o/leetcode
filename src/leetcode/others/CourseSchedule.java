// There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
// which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
// See: https://leetcode.com/problems/course-schedule/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
// See: https://leetcode.com/problems/course-schedule/discuss/658987/Java-Clean-DFS-solution

package leetcode.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    /**
     * Solution 3 - DFS cycle detection - smarter approach. If a directed graph has
     * a cycle => topological sort is impossible.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisit : prerequisites)
            graph.computeIfAbsent(prerequisit[0], k -> new LinkedList<>()).add(prerequisit[1]);
        boolean[] used = new boolean[numCourses];
        boolean[] explored = new boolean[numCourses];

        for (int key : graph.keySet())
            if (detectCycle(key, graph, used, explored))
                return false;

        return true;
    }

    private boolean detectCycle(int currNode, Map<Integer, List<Integer>> graph, boolean[] used,
            boolean[] explored) {

        if (!graph.containsKey(currNode))
            return false;

        used[currNode] = true;

        for (Integer child : graph.get(currNode)) {
            if (explored[currNode])
                continue;

            if (used[child])
                return true;

            if (detectCycle(child, graph, used, explored))
                return true;
        }

        explored[currNode] = true;
        used[currNode] = false;

        return false;
    }

    /**
     * Solution 2 - DFS cycle detection approach with even worst performance
     * (accepted). If a directed graph has a cycle => topological sort is
     * impossible.
     */
    public boolean canFinish_var2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisit : prerequisites)
            graph.computeIfAbsent(prerequisit[0], k -> new LinkedList<>()).add(prerequisit[1]);

        for (int key : graph.keySet())
            if (hasCycle(key, key, graph, new boolean[numCourses]))
                return false;

        return true;
    }

    private boolean hasCycle(int start, int node, Map<Integer, List<Integer>> graph,
            boolean[] used) {
        if (!graph.containsKey(node))
            return false;

        boolean hasCycle = false;
        used[node] = true;
        for (Integer child : graph.get(node)) {
            if (start == child)
                return true;
            if (!used[child])
                hasCycle = hasCycle || hasCycle(start, child, graph, used);
        }

        return hasCycle;
    }

    /**
     * Solution 1 - Initial solution, topological sort (no DFS) - slow, accepted.
     */
    public boolean canFinish_var1(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> parent = new HashMap<>();

        for (int[] prerequisit : prerequisites) {
            graph.computeIfAbsent(prerequisit[0], k -> new HashSet<>()).add(prerequisit[1]);
            parent.computeIfAbsent(prerequisit[1], k -> new HashSet<>()).add(prerequisit[0]);
        }

        while (graph.size() > 0) {
            boolean flag = false;
            for (int key : parent.keySet()) {
                if (!graph.containsKey(key)) {
                    for (int node : parent.get(key)) {
                        if (graph.get(node) != null) {
                            graph.get(node).remove(key);
                            if (graph.get(node).size() == 0) {
                                flag = true;
                                graph.remove(node);
                            }
                        }
                    }
                }
            }
            if (flag == false)
                break;
        }

        return graph.size() == 0;
    }

    public static void main(String[] args) {
        CourseSchedule sln = new CourseSchedule();
        System.out.println(sln.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
////
        System.out
                .println(sln.canFinish(5, new int[][] { { 0, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 } }));
//
        System.out.println(sln.canFinish(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }));
        System.out.println(sln.canFinish(8,
                new int[][] { { 1, 0 }, { 2, 6 }, { 1, 7 }, { 6, 4 }, { 7, 0 }, { 0, 5 } }));
    }

}
