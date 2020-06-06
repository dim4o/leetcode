// Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
// Note:
// The number of people is less than 1,100.
// See: https://leetcode.com/problems/queue-reconstruction-by-height/
// See: https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/

package leetcode.others;

import java.util.Arrays;

public class QueueReconstructionByHeight {

    /**
     * Greedy solution
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[][] rec = new int[people.length][];

        for (int[] person : people) {
            int pos = person[1];
            int i = 0;

            for (int j = 0; j < rec.length; j++) {
                if (pos == i && rec[j] == null) {
                    rec[j] = person;
                    break;
                }
                if (rec[j] == null || rec[j][0] == person[0])
                    i++;
            }
        }

        return rec;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight sln = new QueueReconstructionByHeight();
        int[][] reconstruction = sln.reconstructQueue(
                new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } });
        
        for (int[] p : reconstruction)
            System.out.println(Arrays.toString(p));
    }

}
