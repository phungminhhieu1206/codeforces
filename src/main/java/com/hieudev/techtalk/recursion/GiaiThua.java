package com.hieudev.techtalk.recursion;

import java.util.Scanner;

public class GiaiThua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        while (numTests-- > 0) {
            System.out.print("Nhập số: ");
            int num = sc.nextInt();
            System.out.println("Kết quả giai thừa: " +  giaiThua(num));
        }
    }

    public static int giaiThua(int n) {
        if (n==0) return 1;
        else return n*giaiThua(n-1);
    }
}
