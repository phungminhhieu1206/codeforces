package com.hieudev.string;

import java.util.Arrays;

/**
 * Tìm ký tự đầu tiên mà không bị lặp lại,
 * và trả về index của nó, ko tìm thấy thì return -1;
 */
public class _387_FirstUniqueCharacterInString {
    public static void main(String[] args) {
        String s = "leetcode";
        _387_FirstUniqueCharacterInString obj = new _387_FirstUniqueCharacterInString();
        System.out.println(obj.firstUniqChar(s));
    }

    /**
     * Các chữ thường từ ascii từ 97-122
     */
    public int firstUniqChar(String s) {
        char arr[] = s.toCharArray();
        int count[] = new int[123];

        for (int i = 0; i <arr.length ; i++) {
            char c = arr[i];
            int index = (int)c;
            count[index]++;
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            int index = (int) c;
            if (count[index] == 1) return i;
        }
        return -1;
    }

    public int firstUniqCharWay2(String s) {
        int n = s.length();
        int c[] = new int[n];
        Arrays.fill(c, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    c[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (c[i]==1) {
                return i;
            }
        }

        return -1;
    }


    public int firstUniqCharWay1(String s) {
        int n = s.length();
        if (n==1) return 0;

        int flag[] = new int[n];
        Arrays.fill(flag, 0);

        boolean found = true;

        for (int i = 0; i < n; i++) {
            if (flag[i] == 1) continue;

            for (int j = i+1; j < n; j++) {
                flag[i] = 1;
                if (s.charAt(i) == s.charAt(j)) {
                    flag[j] = 1;
                    found = false;
                }
            }

            if (!found) {
                found = true;
            } else {
                return i;
            }
        }

        return -1;
    }

}
