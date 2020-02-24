// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
// See: https://leetcode.com/problems/restore-ip-addresses/

// TODO: The current solution works but is relatively slow may be because a lot of 
// string concatenation and substring actions.
// Try to find a faster alternative.

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<String>();
        backtrack(s, "", res, 3);
        return res;
    }

    private void backtrack(String s, String ip, List<String> res, int dot) {
        if (isValid(s) && dot == 0) {
            String currRes = ip + s;
            res.add(currRes);
            return;
        }

        if (s.length() >= 1 && isValid("" + s.charAt(0))) {
            backtrack(s.substring(1), ip + s.charAt(0) + ".", res, dot - 1);
        }
        if (s.length() >= 2 && isValid("" + s.charAt(0) + s.charAt(1))) {
            backtrack(s.substring(2), ip + s.charAt(0) + s.charAt(1) + ".", res, dot - 1);
        }
        if (s.length() >= 3 && isValid("" + s.charAt(0) + s.charAt(1) + s.charAt(2))) {
            backtrack(s.substring(3), ip + s.charAt(0) + s.charAt(1) + s.charAt(2) + ".", res, dot - 1);
        }
    }

    private boolean isValid(String ipPart) {
        if (ipPart.equals("0")) {
            return true;
        }
        if (ipPart.isEmpty() || ipPart.length() > 3 || ipPart.charAt(0) == '0' || Integer.parseInt(ipPart) > 255) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddresses sln = new RestoreIPAddresses();
        System.out.println(sln.restoreIpAddresses("25525511135"));
        System.out.println(sln.restoreIpAddresses("0000"));
        System.out.println(sln.restoreIpAddresses("1721701"));
        System.out.println(sln.restoreIpAddresses("1111"));

    }

}
