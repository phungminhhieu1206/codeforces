package com.hieudev.sort;

public class _3_InsertionSort {
    public static void main(String[] args) {
        _3_InsertionSort obj = new _3_InsertionSort();
        int nums[] = {5, 1, 0, 0, 1, 2, 4};

        obj.insertionSort(nums);
        for (int i: nums) {
            System.out.print(i + ",");
        }
    }

    /**
     * (Đặc điểm): Tại vòng lặp thứ i phần từ [0,i] đã được sắp xếp nhưng không hoàn toàn chính xác
     * + Chạy từ đầu đến cuối mảng
     * + Tại vòng lặp thứ i, coi như dãy [0, i-1] đã được sắp xếp, chèn phần tử a[i] vào vị trí thích hợp,
     * + Sau vòng lặp thứ i, thì dãy [0, i] đã được sắp xếp
     */
    public void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // Chèn a[i] vào mảng [0, i-1]
            int ai = a[i];
            int j = i-1;
            while (j>=0 && a[j] > ai) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
        }
    }
}
