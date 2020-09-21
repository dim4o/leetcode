// You are driving a vehicle that has capacity empty seats initially available for passengers.
// The vehicle only drives east (ie. it cannot turn around and drive west.)
// Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains 
// information about the i-th trip: the number of passengers that must be picked up, 
// and the locations to pick them up and drop them off.  The locations are given as the number 
// of kilometers due east from your vehicle's initial location.
// Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
// See: https://leetcode.com/problems/car-pooling/
// See: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/

package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarPooling {

    // Greedy solution (can be optimized further)
    // TODO: Add simpler and cleaner solution
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        List<int[]> tripHelper = new ArrayList<>();
        for (int i = 0; i < trips.length; i++) {
            tripHelper.add(new int[] { trips[i][1], trips[i][0], trips[i][1], trips[i][2] });
            tripHelper.add(new int[] { trips[i][2], -trips[i][0], trips[i][1], trips[i][2] });
        }

        tripHelper.sort((a, b) -> a[0] - b[0]);

        // for (int[] trip : tripHelper)
        // System.out.println(Arrays.toString(trip));

        int currCap = 0;
        for (int[] tr : tripHelper)
            if ((currCap += tr[1]) > capacity)
                return false;

        return true;
    }

    public static void main(String[] args) {
        CarPooling sln = new CarPooling();

        System.out.println(sln.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4)); // false;
        System.out.println(sln.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5)); // true
        System.out.println(sln.carPooling(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 3)); // true
        System.out
                .println(sln.carPooling(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } }, 11)); // true
    }

}
