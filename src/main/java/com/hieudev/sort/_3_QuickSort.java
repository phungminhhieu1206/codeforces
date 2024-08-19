package com.hieudev.sort;

/**
 * O(nlogn)
 */
public class _3_QuickSort {
    public static void main(String[] args) {
        _3_QuickSort obj = new _3_QuickSort();
        int nums[] = {5, 1, 0, 0, 1, 2, 4};

        obj.quickSort(nums);
        for (int i: nums) {
            System.out.print(i + ",");
        }
    }

    public void quickSort(int[] nums) {
        // solve...
    }
}
