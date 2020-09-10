// You are playing the following Bulls and Cows game with your friend: You write
// down a number and ask your friend to guess what the number is. Each time your
// friend makes a guess, you provide a hint that indicates how many digits in
// said guess match your secret number exactly in both digit and position
// (called "bulls") and how many digits match the secret number but locate in
// the wrong position (called "cows"). Your friend will use successive guesses
// and hints to eventually derive the secret number.
//  
// Write a function to return a hint according to the secret number and friend's
// guess, use A to indicate the bulls and B to indicate the cows.
//  
// Please note that both secret number and friend's guess may contain duplicate
// digits.
// See: https://leetcode.com/problems/bulls-and-cows/
// See: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3455/

package leetcode.array_and_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {

    /**
     * Note: this is not of my favorites type of problems and therefore my solution
     * is ugly and stupid, but I have not time and patience now to optimize it...
     * TODO: add a better solution
     */
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++)
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);

        int bulls = 0;
        int cows = 0;
        Set<Integer> bullsIdxs = new HashSet<>();
        for (int i = 0; i < guess.length(); i++) {
            char curr = guess.charAt(i);
            if (curr == secret.charAt(i)) {
                bulls++;
                map.put(curr, map.get(curr) - 1);
                bullsIdxs.add(i);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char curr = guess.charAt(i);
            if (map.containsKey(curr) && map.get(curr) != 0 && !bullsIdxs.contains(i)) {
                cows++;
                map.put(curr, map.get(curr) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows sln = new BullsAndCows();
        System.out.println(sln.getHint("1807", "7810")); // 1A3B
        System.out.println(sln.getHint("1123", "0111")); // 1A1B
        System.out.println(sln.getHint("11", "10")); // 1A0B
        System.out.println(sln.getHint("11", "01")); // 1A0B
        System.out.println(sln.getHint("1123", "0111")); // 1A1B
    }

}
