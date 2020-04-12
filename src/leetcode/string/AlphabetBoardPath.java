// On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
// See: https://leetcode.com/problems/alphabet-board-path/

package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        Map<Character, Integer[]> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) 
            map.put(i, new Integer[] {(i - 97) / 5,  (i - 97) % 5 });
        
        char prev = 'a';
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char currChar = target.charAt(i);
            int xDiff = map.get(currChar)[1] - map.get(prev)[1];
            int yDiff = map.get(currChar)[0] - map.get(prev)[0];
            
            if (yDiff != 0)
                for (int j = 0; j < Math.abs(yDiff); j++) 
                    if (yDiff > 0) res.append('D'); else res.append('U');
            
            if (currChar == 'z' && prev != 'z')
                res.setLength(res.length() - 1);
            
            if (xDiff != 0)
                for (int j = 0; j < Math.abs(xDiff); j++)
                    if (xDiff > 0) res.append('R'); else res.append('L');
            
            if (currChar == 'z' && prev != 'z')
                res.append('D');
            
            res.append('!');
            prev = currChar;
        }
        
        return res.toString();
    }

    public static void main(String[] args) {
        AlphabetBoardPath sln = new AlphabetBoardPath();

//        System.out.println(sln.alphabetBoardPath("leet"));
//        System.out.println(sln.alphabetBoardPath("code"));
//        System.out.println(sln.alphabetBoardPath("abcd"));
//        System.out.println(sln.alphabetBoardPath("zdz"));
        System.out.println(sln.alphabetBoardPath("zz"));
        System.out.println(sln.alphabetBoardPath("aa"));
        System.out.println(sln.alphabetBoardPath("aba"));
    }

}
