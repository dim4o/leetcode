// Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list 
// of favorite restaurants represented by strings.
// You need to help them find out their common interest with the least list index sum. 
// If there is a choice tie between answers, output all of them with no order requirement. 
// You could assume there always exists an answer.
// See: https://leetcode.com/problems/minimum-index-sum-of-two-lists/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map1.put(list1[i], i);
        for (int i = 0; i < list2.length; i++)
            map2.put(list2[i], i);
        
        List<String> res = new LinkedList<String>();

        int minIndexSum = Integer.MAX_VALUE;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int currIdxSum = map1.get(key) + map2.get(key);
                minIndexSum = Math.min(minIndexSum, currIdxSum);
                map2.put(key, currIdxSum);
            }
        }

        for (String key : map2.keySet())
            if (map2.get(key) == minIndexSum && map1.containsKey(key)) 
                res.add(key);

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists sln = new MinimumIndexSumOfTwoLists();
        System.out.println(Arrays.toString(sln.findRestaurant(
                new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
                new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
                        "Shogun" })));
        
        System.out.println(Arrays.toString(sln.findRestaurant(
                new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
                new String[] { "KFC", "Shogun", "Burger King" })));
    }

}
