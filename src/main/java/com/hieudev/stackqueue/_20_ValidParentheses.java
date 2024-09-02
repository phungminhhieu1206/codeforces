package com.hieudev.stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Kiểm tra chuỗi dấu ngoặc đúng?
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * + Open brackets must be closed by the same type of brackets.
 * + Open brackets must be closed in the correct order.
 * + Every close bracket has a corresponding open bracket of the same type.
 * eg: "()" -> true, "()[]{}" -> true, "(]" -> false, "([])" -> true
 */
public class _20_ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("result: " + isValid(str));
    }

    public static boolean isValid(String s) {
        if(s.length()%2 != 0) {
            return false;
        }
        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<c.length; i++) {
            if (c[i] == '(') {
                stack.push(')');
            } else if (c[i] == '[') {
                stack.push(']');
            } else if (c[i] == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.empty();
    }
}
