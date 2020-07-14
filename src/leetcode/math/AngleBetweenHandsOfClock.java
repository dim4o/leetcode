// Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
// See: https://leetcode.com/problems/angle-between-hands-of-a-clock/
// See: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/

package leetcode.math;

public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        hour = hour != 12 ? hour : 0;
        
        double coef = minutes/60.0;
        double hourDeg = 30 * coef;
        double minDeg = 360 * coef;
        
        double res = Math.abs(hour * 30 + hourDeg - minDeg);
        
        return res > 180 ? 360 - res : res;
    }

    public static void main(String[] args) {
        AngleBetweenHandsOfClock sln = new AngleBetweenHandsOfClock();
        System.out.println(sln.angleClock(4, 50));
        System.out.println(sln.angleClock(3, 15));
        System.out.println(sln.angleClock(12, 0));
        System.out.println(sln.angleClock(3, 30));
        System.out.println(sln.angleClock(12, 30));
        System.out.println(sln.angleClock(1, 57));
    }

}
