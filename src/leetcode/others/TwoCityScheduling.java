// There are 2N people a company is planning to interview. The cost of flying the i-th person to city A 
// is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
// Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
// See: https://leetcode.com/problems/two-city-scheduling/
// See: https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/

package leetcode.others;

import java.util.Arrays;

public class TwoCityScheduling {
    // TODO: Try Dynamic Programming approach

    /**
     * The solution seems very easy but is not ...
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        // for (int[] pair : costs) {
        //     System.out.println(Arrays.toString(is));

        int minCost = 0;
        for (int i = 0; i < costs.length; i++)
            minCost += i < costs.length / 2 ? costs[i][0] : costs[i][1];

        return minCost;
    }

    public static void main(String[] args) {
        TwoCityScheduling sln = new TwoCityScheduling();
        System.out.println(sln.twoCitySchedCost(
                new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } }));
        System.out.println(sln.twoCitySchedCost(new int[][] { { 259, 770 }, { 448, 54 },
                { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } }));
    }

}
