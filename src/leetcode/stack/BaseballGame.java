// You're now a baseball game point recorder.
// Given a list of strings, each string can be one of the 4 following types:
//   1. Integer (one round's score): Directly represents the number of points you get in this round.
//   2. "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
//   3. "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
//   4. "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
// Each round's operation is permanent and could have an impact on the round before and the round after.
// You need to return the sum of the points you could get in all the rounds.
// See: https://leetcode.com/problems/baseball-game/

package leetcode.stack;

import java.util.Stack;

public class BaseballGame {
    // The usage of the stack here is not essential because I need of the last two valid scores only.
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int score = 0;

        for (String opt : ops) {
            switch (opt) {
            case "+":
                int sum = stack.peek() + stack.get(stack.size() - 2);
                score += sum;
                stack.add(sum);
                break;
            case "C":
                score -= stack.pop();
                break;
            case "D": 
                score += stack.peek() * 2;
                stack.add(stack.peek() * 2);
                break;
            default:
                int sc = Integer.parseInt(opt);
                stack.add(sc);
                score += sc;
                break;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        BaseballGame sln = new BaseballGame();

        System.out.println(sln.calPoints(new String[] { "5", "2", "C", "D", "+" }));
        System.out.println(sln.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));

    }

}
