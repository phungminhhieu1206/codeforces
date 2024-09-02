package com.hieudev.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * input: [1,2,3,1], [1,2,3,4]
 * output: true, false
 *
 * Cho 1 mảng, return true nếu có phần tử trùng lặp!
 * Giải pháp: Duyệt mảng, thêm lần lượt vào hashset,
 * return true nếu phần tử duyệt đã có trong set
 *
 * Các hàm hay dùng trong HashSet:
 * add(), contains(), ...
 */
public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int num: nums) {
            if (mySet.contains(num)) return true;
            mySet.add(num);
        }

        return false;
    }
}
