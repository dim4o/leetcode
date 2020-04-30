// A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates 
// of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
// Two rectangles overlap if the area of their intersection is positive.  
// To be clear, two rectangles that only touch at the corner or edges do not overlap.
// Given two (axis-aligned) rectangles, return whether they overlap.
// See: https://leetcode.com/problems/rectangle-overlap/

package leetcode.math;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) { 
        int r1x1 = rec1[0];
        int r1y1 = rec1[1];
        int r1x2 = rec1[2];
        int r1y2 = rec1[3];
        
        int r2x1 = rec2[0];
        int r2y1 = rec2[1];
        int r2x2 = rec2[2];
        int r2y2 = rec2[3];
        
        if (r1y1 >=r2y2 || r1y2 <= r2y1 || r1x1 >= r2x2 || r1x2 <= r2x1)
            return false;
        
        return true;
    }

    public static void main(String[] args) {
        RectangleOverlap sln = new RectangleOverlap();

        System.out.println(
                sln.isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 }));
    }

}
