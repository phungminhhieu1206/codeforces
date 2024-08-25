package com.hieudev.array;

/**
 * Kỹ thuật duyệt mảng
 */
public class _1295_FindNumberWithEvenNumOfDigits {
    public static void main(String[] args) {
        _1295_FindNumberWithEvenNumOfDigits obj = new _1295_FindNumberWithEvenNumOfDigits();
        int[] a = {1, 23, 212, 0};
        System.out.println("result: " + obj.findNumbers(a));
    }

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i: nums) {
            if (countDigits(i)%2==0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Dem so luong cs cua 1 so
     */
    public int countDigits(int num) {
        int totalDigits = 0;

        do {
            num=num/10;
            totalDigits++;
        } while (num != 0);

        return totalDigits;
    }
}
