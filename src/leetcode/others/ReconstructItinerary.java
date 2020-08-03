// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
// reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
// Thus, the itinerary must begin with JFK.
// See: https://leetcode.com/problems/reconstruct-itinerary/
// See: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/

package leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReconstructItinerary {

    /**
     * Actually the problem is to find a Euler path. Not very nice but working
     * solution. TODO: Find faster solution
     */
    private List<String> res = null;

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++)
            graph.computeIfAbsent(tickets.get(i).get(0), t -> new ArrayList<>()).add(i);

        for (Map.Entry<String, List<Integer>> entry : graph.entrySet())
            entry.getValue().sort((a, b) -> tickets.get(a).get(1).compareTo(tickets.get(b).get(1)));

        LinkedList<String> l = new LinkedList<>();
        l.add("JFK");
        dfs(tickets, graph, "JFK", new HashSet<>(), l);

        return res;
    }

    private void dfs(List<List<String>> tickets, Map<String, List<Integer>> graph,
            String currAirport, Set<Integer> used, LinkedList<String> path) {
        if (res != null)
            return;

        if (used.size() == tickets.size()) {
            res = new ArrayList<>(path);
            return;
        }

        for (int ticketIdx : graph.getOrDefault(currAirport, new ArrayList<>())) {
            if (!used.contains(ticketIdx)) {
                used.add(ticketIdx);
                path.add(tickets.get(ticketIdx).get(1));
                dfs(tickets, graph, tickets.get(ticketIdx).get(1), used, path);
                path.removeLast();
                used.remove(ticketIdx);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> tickets1 = List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"),
                List.of("SFO", "ATL"), List.of("ATL", "JFK"), List.of("ATL", "SFO"));
        List<List<String>> tickets2 = List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"),
                List.of("SFO", "SJC"), List.of("LHR", "SFO"));

        List<List<String>> tickets3 = List.of(List.of("EZE", "AXA"), List.of("TIA", "ANU"),
                List.of("ANU", "JFK"), List.of("JFK", "ANU"), List.of("ANU", "EZE"),
                List.of("TIA", "ANU"), List.of("AXA", "TIA"), List.of("TIA", "JFK"),
                List.of("ANU", "TIA"), List.of("JFK", "TIA"));

        System.out.println(new ReconstructItinerary().findItinerary(tickets1));
        System.out.println(new ReconstructItinerary().findItinerary(tickets2));
        System.out.println(new ReconstructItinerary().findItinerary(tickets3));
    }

}
