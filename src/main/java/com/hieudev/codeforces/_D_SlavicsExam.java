package com.hieudev.codeforces;

import java.util.Scanner;

public class _D_SlavicsExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while (n-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            int flag = 0;
            int m = s2.length()-1;
            String demo = "";
            for (int i = 0; i < s1.length(); i++) {

                char c = s1.charAt(flag);
                String temp = c == '?' ? "a" : String.valueOf(c);
                if (flag==m) {
                    demo += c;
                }

                if (s2.charAt(i) == c || c == '?') {
                    temp = c == '?' ? String.valueOf(c) : "a";
                    flag++;
                }
            }
        }
    }
}
