package com.hieudev.sort;

/**
 * O(nlogn)
 */
public class _4_MergeSort {
    public static void main(String[] args) {
        _4_MergeSort obj = new _4_MergeSort();
        int nums[] = {5, 1, 0, 0, 1, 2, 4};

        obj.mergeSort(nums);
        for (int i: nums) {
            System.out.print(i + ",");
        }
    }

    public void mergeSort(int[] nums) {
        // solve...
    }
}
