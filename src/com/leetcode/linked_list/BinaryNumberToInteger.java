// Given head which is a reference node to a singly-linked list. 
// The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.
// See: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;

import java.util.Stack;

import com.leetcode.linked_list.util.ListNode;

public class BinaryNumberToInteger {
    public int getDecimalValue(ListNode node) {
        Stack<Integer> s = new Stack<>();
        while (node != null) {
            s.push(node.val);
            node = node.next;
        }
        int result = 0;
        int pow = 1;
        while (!s.empty()) {
            result += s.pop() * pow;
            pow = pow * 2;
        }
        return result;
    }

    public static void main(String... args) {
        BinaryNumberToInteger sln = new BinaryNumberToInteger();

        System.out.println(sln.getDecimalValue(initList(1, 0, 1)) == 5);
        System.out.println(sln.getDecimalValue(initList(0)) == 0);
        System.out.println(sln.getDecimalValue(initList(1)) == 1);
        System.out.println(sln.getDecimalValue(
                initList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)) == 18880);
        System.out.println(sln.getDecimalValue(initList(0, 0)) == 0);
    }
}
