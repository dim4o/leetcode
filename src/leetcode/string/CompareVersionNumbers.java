// Compare two version numbers version1 and version2.
// If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
// See: https://leetcode.com/problems/compare-version-numbers/
// See: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/

package leetcode.string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int b = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (a != b) 
                return a < b ? -1 : 1;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers sln = new CompareVersionNumbers();
        System.out.println(sln.compareVersion("0.1", "1.1")); // -1
        System.out.println(sln.compareVersion("1.0.1", "1")); // 1
        System.out.println(sln.compareVersion("7.5.2.4", "7.5.3")); // -1
        System.out.println(sln.compareVersion("1.01", "1.001")); // 0
        System.out.println(sln.compareVersion("1.0", "1.0.0")); // 0
    }

}
