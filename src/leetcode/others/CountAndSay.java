// See: https://leetcode.com/problems/count-and-say/

package leetcode.others;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < prev.length(); i++)
            if (prev.charAt(i) == prev.charAt(i - 1))
                count++;
            else {
                sb.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        sb.append(count).append(prev.charAt(prev.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay sln = new CountAndSay();

        System.out.println(sln.countAndSay(1)); // 1
        System.out.println(sln.countAndSay(2)); // 11
        System.out.println(sln.countAndSay(3)); // 21
        System.out.println(sln.countAndSay(4)); // 1211
        System.out.println(sln.countAndSay(5)); // 111221
        System.out.println(sln.countAndSay(6)); // 312211
        System.out.println(sln.countAndSay(7)); // 13112221
    }

}
