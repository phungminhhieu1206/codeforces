package com.hieudev.sort;

/**
 * O(nlogn)
 */
public class _5_QuickSort {
    public static void main(String[] args) {
        _5_QuickSort obj = new _5_QuickSort();
        int nums[] = {5, 1, 0, 0, 1, 2, 4};

        obj.quickSort(nums, 0, nums.length-1);
        for (int i: nums) {
            System.out.print(i + ",");
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l<r) {
            int pivot = findPivot(nums, l, r);
            quickSort(nums, l, pivot-1);
            quickSort(nums, pivot+1, r);
        }
    }

    /**
     * Chọn phần tử cuối làm pivot
     * For từ đầu đến kế cuối
     * flag: đánh dấu index của phần tử sẽ swap tiếp theo
     */
    public int findPivot(int[] arr, int l, int r) {
        int pivot = arr[r];
        int flag = l;

        for(int j=l; j<r; j++) {
            if(arr[j] < pivot) {

                // swap
                int temp = arr[flag];
                arr[flag] = arr[j];
                arr[j] = temp;

                flag++;
            }
        }
        int temp = arr[flag];
        arr[flag] = arr[r];
        arr[r] = temp;

        return flag;
    }
}
