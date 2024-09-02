package com.hieudev.stackqueue.stack;

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

    // Nhanh hơn cách 1
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // case gặp dấu đóng ngoặc luôn khi chưa có dấu mở ngoặc:
                if (stack.isEmpty()) return false;

                char openPeek = stack.peek();
                if ((openPeek == '(' && c == ')') ||
                        (openPeek == '[' && c == ']') ||
                        (openPeek == '{' && c == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidWay1(String s) {
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
