package com.hieudev.codeforces;

import java.util.Scanner;

public class _A_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while (n-- > 0 ) {
            int num = sc.nextInt();
            System.out.println(num%10 + num/10);
        }
    }
}
