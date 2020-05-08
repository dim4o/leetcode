// You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
// Check if these points make a straight line in the XY plane.
// See: https://leetcode.com/problems/check-if-it-is-a-straight-line/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
// See: https://leetcode.com/problems/check-if-it-is-a-straight-line/discuss/620113/The-Test-Cases-are-Incomplete

package leetcode.math;

public class CheckIfItIsStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        boolean vertical = x1 == x2;
        double a = (double) (y1 - y2) / (x1 - x2);
        double b = y1 - a * x1;

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if ((!vertical && a * x + b != y) || (vertical && x1 != x))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfItIsStraightLine sln = new CheckIfItIsStraightLine();

        System.out.println(sln.checkStraightLine(
                new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));

        // Vertical line test
        System.out.println(sln.checkStraightLine(
                new int[][] { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 } }));
    }

}
