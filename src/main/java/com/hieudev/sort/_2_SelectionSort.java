package com.hieudev.sort;

// O(n^2)
public class _2_SelectionSort {
    public static void main(String[] args) {
        _2_SelectionSort obj = new _2_SelectionSort();
        int nums[] = {5, 1, 0, 0, 1, 2, 4};

        obj.selectionSort(nums);
        for (int i: nums) {
            System.out.print(i + ",");
        }
    }

    /**
     * + Chạy từ đầu đến cuối mảng
     * + Tại vòng lặp thứ i, tìm phần tử nhỏ nhất phía bên phải nó [i+1,n-1],
     * nếu nhỏ hơn a[i] thì đổi chỗ cho a[i]
     * + Sau vòng lặp i thì dãy [0,i] được sắp xếp
     */
    public void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j=i+1; j<n; j++) {
                if (a[j] < a[i]) {
                    // swap
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j]; // a[i]
                    a[i] = a[i] - a[j];
                }
            }
        }
    }

}
