package com.hieudev.array;

public class _88_MergeSortedArray {
    public static void main(String[] args) {
        _88_MergeSortedArray obj = new _88_MergeSortedArray();
        int nums1[] = {1,2,3,0,0,0};
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;

        obj.merge(nums1, m, nums2, n);
        for(int i: nums1){
            System.out.print(i + ",");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m+n];

        for (int i=m; i<m+n; i++) {
            nums1[i] = nums2[i-m];
        }

        bubbleSort(nums1);
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
