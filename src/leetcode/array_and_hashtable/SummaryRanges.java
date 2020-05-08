// Given a sorted integer array without duplicates, return the summary of its ranges.
// See: https://leetcode.com/problems/summary-ranges/

package leetcode.array_and_hashtable;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums.length == 1) 
            res.add("" + nums[0]);
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                if (i == nums.length - 1)
                    res.add(String.format("%s->%s", nums[start], nums[i]));
            } else {
                if ( nums[start] != nums[i-1])
                    res.add(String.format("%s->%s", nums[start], nums[i-1]));

                if (nums[start] == nums[i-1]) 
                    res.add(String.format("%s", nums[i-1]));
                
                if (i == nums.length - 1) 
                    res.add(String.format("%s", nums[i]));
                
                start = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges sln = new SummaryRanges();
        System.out.println(sln.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
        System.out.println(sln.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
        System.out.println(sln.summaryRanges(new int[] { 0, 2, 4, 6, 8 }));
        System.out.println(sln.summaryRanges(new int[] { 1, 2, 3, 4 }));
        System.out.println(sln.summaryRanges(new int[] { 0, 2, 3, 4, 6 }));
        System.out.println(sln.summaryRanges(new int[] { 1 }));
        System.out.println(sln.summaryRanges(new int[] { -1 }));
        System.out.println(sln.summaryRanges(new int[] { 1, 2 }));
        System.out.println(sln.summaryRanges(new int[] { 1, 3 }));
    }

}
