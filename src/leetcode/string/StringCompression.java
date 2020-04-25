// Given an array of characters, compress it in-place.
// The length after compression must always be smaller than or equal to the original array.
// Every element of the array should be a character (not int) of length 1.
// After you are done modifying the input array in-place, return the new length of the array.
// Follow up:
// Could you solve it using only O(1) extra space?
// See: https://leetcode.com/problems/string-compression/

package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    // TODO: solve it using O(1) space (no helper array).
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;

        List<int[]> list = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1])
                count++;

            if (chars[i] != chars[i + 1] || i == chars.length - 2) {
                list.add(new int[] { chars[i], count });
                count = 1;
                if (chars[i] != chars[i + 1] && i == chars.length - 2)
                    list.add(new int[] { chars[i + 1], count });
            }

        }

        int pos = 0;
        for (int[] pair : list) {
            chars[pos] = (char) pair[0];
            count = pair[1];
            if (count > 1) {
                char[] digits = String.valueOf(count).toCharArray();
                for (char digit : digits) {
                    chars[pos + 1] = digit;
                    pos += 1;
                }
            }
            pos += 1;
        }

        // System.out.println(Arrays.toString(chars));

        return pos;
    }

    public static void main(String[] args) {
        StringCompression sln = new StringCompression();

        System.out.println(sln.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));

        System.out.println(sln.compress(new char[] { 'a' }));

        System.out.println(sln.compress(
                new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));

        System.out.println(sln.compress(new char[] { 'a', 'a', 'a', 'b', 'b', 'a', 'a' }));

        System.out.println(sln.compress(new char[] { 'a', 'b', 'c' }));

    }

}
