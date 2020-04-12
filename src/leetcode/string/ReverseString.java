package leetcode.string;

public class ReverseString {
    public void reverseString(char[] s) {
        reverse(s, 0);
    }
    
    private void reverse(char[] s, int pos) {
        if (pos == s.length/2) return;
        char tmp = s[pos];
        s[pos] = s[s.length - pos - 1];
        s[s.length - pos - 1] = tmp;
        reverse(s, pos + 1);
    }
}
