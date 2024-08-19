package com.hieudev.sort;

/**
 * O(n^2)
 */
public class _1_BubbleSort {
    public static void main(String[] args) {
        _1_BubbleSort obj = new _1_BubbleSort();
        int nums[] = {5, 1, 0, 0, 1, 2, 4};

        obj.bubbleSort(nums);
        for (int i: nums) {
            System.out.print(i + ",");
        }
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    // swap
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
