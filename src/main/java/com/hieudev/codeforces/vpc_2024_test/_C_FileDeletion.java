package com.hieudev.codeforces.vpc_2024_test;
import java.util.Scanner;

public class _C_FileDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        char[] c = new char[n + 1];
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            c[i] = scanner.next().charAt(0);
            a[i] = scanner.nextInt(); // Độ dài của file
        }

        // Duyệt qua từng file để cập nhật dp
        for (int i = 1; i <= n; i++) {
            if (c[i] == 'y') {
                dp[i] = dp[i - 1] + 1; // Xóa riêng file 'y' này
                int sumLength = a[i]; // Độ dài của vùng chọn bắt đầu từ file i

                for (int j = i - 1; j >= 1; j--) {
                    if (c[j] == 'n') break; // Gặp 'n' thì dừng
                    sumLength += a[j]; // Tính tổng độ dài của vùng chọn mới
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            } else {
                dp[i] = dp[i - 1];  // Nếu là 'n', số thao tác không thay đổi
            }
        }

        System.out.println(dp[n]);
    }
}

