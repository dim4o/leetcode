// You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
// Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
// The letters in J are guaranteed distinct, and all characters in J and S are letters. 
// Letters are case sensitive, so "a" is considered a different type of stone from "A".
// See: https://leetcode.com/problems/jewels-and-stones/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/

package leetcode.leetcode_challenge;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++)
            set.add(J.charAt(i));

        int count = 0;
        for (int i = 0; i < S.length(); i++)
            if (set.contains(S.charAt(i)))
                count++;

        return count;
    }

}
