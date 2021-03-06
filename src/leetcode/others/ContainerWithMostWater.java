// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
// which together with x-axis forms a container, such that the container contains the most water.
// Note: You may not slant the container and n is at least 2.
// See: https://leetcode.com/problems/container-with-most-water/

package leetcode.others;

public class ContainerWithMostWater {

    /**
     * Two pointers solution (accepted).
     */
    public int maxArea(int[] height) {
        int max = -1;
        int l = 0, r = height.length - 1;

        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }

    /**
     * Naive solution (accepted).
     */
    public int maxArea_naive(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sln = new ContainerWithMostWater();

        System.out.println(sln.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(sln.maxArea(new int[] { 1, 1 }));
        System.out.println(sln.maxArea(new int[] { 1, 2, 1 }));

        System.out.println(sln.maxArea(new int[] { 1, 3, 2, 5, 25, 24, 5 }));
    }

}
