// Given a date, return the corresponding day of the week for that date.
// The input is given as three integers representing the day, month and year respectively.
// Return the answer as one of the following values 
// {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
// See: https://leetcode.com/problems/day-of-the-week/

package leetcode.others;

public class DayOfTheWeek {
    /**
     * TODO: Solution 3 using basic calculations
     */
    
    /**
     * Solution 2 - Zeller's congruence formula
     * @see: https://en.wikipedia.org/wiki/Zeller%27s_congruence
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int dayOfWeek = (day - 1 + 13*(month + 1)/5 + year % 100 + (year % 100)/4 + (year/400) - 2 * (year / 100)) % 7;
        return weekDays[(dayOfWeek + 7) % 7];
    }
    
    /**
     * Solution 1 - Java API
     */
    public String dayOfTheWeek_var1(int day, int month, int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, day - 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        String weekDay = java.time.DayOfWeek.of(dayOfWeek).name();
        return weekDay.substring(0, 1) + weekDay.substring(1).toLowerCase();
    }
    
    
    public static void main(String[] args) {
        DayOfTheWeek sln = new DayOfTheWeek();
        System.out.println(sln.dayOfTheWeek(31, 8, 2019)); // Saturday
        System.out.println(sln.dayOfTheWeek(24, 5, 2020)); // Sunday
    }

}
