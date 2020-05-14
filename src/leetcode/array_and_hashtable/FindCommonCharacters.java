// Given an array A of strings made only from lowercase letters, return a list of all characters 
// that show up in all strings within the list (including duplicates).  
// For example, if a character occurs 3 times in all strings but not 4 times, 
// you need to include that character three times in the final answer.
// You may return the answer in any order.
// See: https://leetcode.com/problems/find-common-characters/
        
package leetcode.array_and_hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    /**
     * Solution 1 - accepted.
     * Not very fast nor elegant, but working solution.
     * TODO: There is a smarter solution - find it! 
     */
    public List<String> commonChars(String[] A) {
        int minLen = 100;
        String shortest = A[0];
        List<String> ans = new LinkedList<>();
        List<Map<Character, Integer>> mapList = new LinkedList<>();
        for (String s : A) {
            if (s.length() < minLen) {
                minLen = s.length();
                shortest = s;
            }
            Map<Character, Integer> currMap = new HashMap<>();
            for (char ch : s.toCharArray())
                currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);
            mapList.add(currMap);
        }

        for (char ch : shortest.toCharArray()) {
            boolean flag = true;
            for (Map<Character, Integer> map : mapList) {
                if (map.containsKey(ch) && map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(String.valueOf(ch));
        }

        return ans;
    }

    public static void main(String[] args) {
        FindCommonCharacters sln = new FindCommonCharacters();
        System.out.println(sln.commonChars(new String[] {"bella","label","roller"}));
        System.out.println(sln.commonChars(new String[] {"cool","lock","cook"}));
    }

}
