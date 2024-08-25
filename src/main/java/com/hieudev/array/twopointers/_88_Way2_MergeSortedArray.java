package com.hieudev.array.twopointers;

/**
 * [Kỹ thuật 2 con trỏ] Thêm phần tử vào mảng
 */
public class _88_Way2_MergeSortedArray {
    public static void main(String[] args) {
        _88_Way2_MergeSortedArray obj = new _88_Way2_MergeSortedArray();
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
        int i=m-1;
        int j=n-1;
        int s=m+n-1;
        for (int k=s;k>=0;k--) {
            if (j<0) {
                return;
            }

            if (i<0 || nums1[i]<nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
        }
    }
}
