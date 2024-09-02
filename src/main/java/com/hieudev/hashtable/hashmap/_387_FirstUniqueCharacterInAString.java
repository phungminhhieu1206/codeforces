package com.hieudev.hashtable.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Cho 1 string, trả về vị trí của ký tự đầu tiên không bị lặp lại!
 * Giải pháp:
 * [Cách 1] - phần string: Đếm số lần xuất hiện của các ký tự trong chuỗi.
 * Ví dụ: "leetcode" -> [1,3,3,1,1,1,1,3]
 * Sau đó duyệt mảng trên và trả về index của phần tử có gía trị 1 đầu tiên,
 * nếu ko tìm được thì return -1.
 * => Cách này cần dùng mảng phụ dựa vào ascii của char, mảng phụ này với
 * index là ascii của char, duyệt string và count++ cho item có index tương ứng.
 *
 * [Cách 2]: Dùng HashMap với key là char và value là số lượng char đó trong chuỗi
 * Các hàm hay dùng trong HashSet:
 * put(k,v), get(k), containsKey(k)
 */
public class _387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (myMap.containsKey(c)) {
                int curValueC = myMap.get(c);
                myMap.put(c, curValueC+1);
            } else {
                myMap.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (myMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
