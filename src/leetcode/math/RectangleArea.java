// Find the total area covered by two rectilinear rectangles in a 2D plane.
// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
// See: https://leetcode.com/problems/rectangle-area/

package leetcode.math;

public class RectangleArea {

    public int computeArea(int r1x1, int r1y1, int r1x2, int r1y2, int r2x1, int r2y1, int r2x2,
            int r2y2) {
        int r1 = Math.abs(r1x1 - r1x2) * Math.abs(r1y1 - r1y2);
        int r2 = Math.abs(r2x1 - r2x2) * Math.abs(r2y1 - r2y2);
        // if not overlap
        if (r1y1 >= r2y2 || r1y2 <= r2y1 || r1x1 >= r2x2 || r1x2 <= r2x1)
            return r1 + r2;
        
        int deltaX = Math.min(r1x2, r2x2) - Math.max(r1x1, r2x1);
        int deltaY = Math.min(r1y2, r2y2) - Math.max(r1y1, r2y1);
        
        return r1 + r2 - deltaX * deltaY;
    }

    public static void main(String[] args) {
        RectangleArea sln = new RectangleArea();

        System.out.println(sln.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

}
