// A school is trying to take an annual photo of all the students. 
// The students are asked to stand in a single file line in non-decreasing order by height. 
// Let this ordering be represented by the integer array expected where expected[i] is the expected 
// height of the ith student in line.
//
// You are given an integer array heights representing the current order that the students are standing in. 
// Each heights[i] is the height of the ith student in line (0-indexed).
//
// Return the number of indices where heights[i] != expected[i].
//
// See: https://leetcode.com/problems/height-checker/
// See: https://leetcode.com/problems/height-checker/discuss/1511848/Concise-O(n)-time-Java-solution

package leetcode.array_and_hashtable;

import java.util.stream.IntStream;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] helper = new int[101];
        for (int num : heights)
            helper[num]++;
        
        int count = 0, h = 0;
        for (int i = 0; h < heights.length; i++) {
            while (helper[i]-- > 0) {
                if (heights[h] != i)
                    count++;
                h++;
            }
        }
        
        return count;
    }
    
    public int heightChecker1(int[] heights) {
        int count = 0;
        int[] expected = IntStream.of(heights).sorted().toArray();

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
}
