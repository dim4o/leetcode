// Create a timebased key-value store class TimeMap, that supports two operations.
//     - set(string key, string value, int timestamp)
//     - get(string key, int timestamp)
// See: https://leetcode.com/problems/time-based-key-value-store/

package leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    // Set operation -> O(1) time complexity
    // Get operation -> O(LogN) time complexity
    // The solution can be done easier with Arrays.binarySerach or TreeMap
    // The time complexity of the set operation will be O(logN) for TreeMap implementation
    class TimeMap {
        private Map<String, List<Integer>> keyToTimestampMap = new HashMap<String, List<Integer>>();
        private Map<String, List<String>> keyToValuesMap = new HashMap<String, List<String>>();

        public void set(String key, String value, int timestamp) {
            List<Integer> tsForKey = keyToTimestampMap.getOrDefault(key, new ArrayList<>());
            List<String> valsForKey = keyToValuesMap.getOrDefault(key, new ArrayList<>());
            tsForKey.add(timestamp);
            valsForKey.add(value);
            keyToTimestampMap.put(key, tsForKey);
            keyToValuesMap.put(key, valsForKey);
        }

        public String get(String key, int timestamp) {
            List<Integer> tsForKey = keyToTimestampMap.getOrDefault(key, null);

            if (tsForKey == null || timestamp < tsForKey.get(0))
                return "";
            
            int timestampIndex = search(tsForKey, timestamp);
            List<String> valsForKey = keyToValuesMap.get(key);

            return valsForKey.get(timestampIndex);
        }

        private int search(List<Integer> tsForKey, int timestamp) {
            if (timestamp > tsForKey.get(tsForKey.size() - 1))
                return tsForKey.size() - 1;

            int lo = 0,  hi = tsForKey.size(), pivot = 0;
            while (lo <= hi) {
                pivot = (lo + hi) / 2;
                if (tsForKey.get(pivot) == timestamp) {
                    return pivot;
                } else if (timestamp > tsForKey.get(pivot)) {
                    if (tsForKey.get(pivot + 1) > timestamp)
                        return pivot;
                    lo = pivot + 1;
                } else {
                    if (tsForKey.get(pivot - 1) < timestamp)
                        return pivot - 1;
                    hi = pivot - 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        TimeMap kv = new TimeBasedKeyValueStore().new TimeMap();

//        Integer[] arr = new Integer[] {-2, -1, 0, 2, 4, 6, 8};
//        Integer[] arr = new Integer[] {1};
//        System.out.println(kv.search(Arrays.asList(arr), 3));
//        System.out.println(kv.search(Arrays.asList(arr), -3));

        kv.set("foo", "bar", 1);
        System.out.println(kv.get("foo", 1));
        System.out.println(kv.get("foo", 3));
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 4));
        System.out.println(kv.get("foo", 5));

        System.out.println();

        kv.set("love", "high", 10);
        kv.set("love", "low", 20);

        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));

        kv = new TimeBasedKeyValueStore().new TimeMap();

    }

}
