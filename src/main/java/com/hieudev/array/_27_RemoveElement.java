package com.hieudev.array;

/**
 * Xóa phần tử khỏi mảng
 */
public class _27_RemoveElement {
    public static void main(String[] args) {
        _27_RemoveElement obj = new _27_RemoveElement();
        int nums[] = {3,2,2,3,3};
        int val = 3;

        System.out.println(obj.removeElement(nums, val));

        // print
        for (int i: nums) {
            System.out.print(i + ",");
        }


    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int numsExist = n;
        for (int i = 0; i < numsExist; ) {
            if (nums[i] == val) {
                // xoa ai
                numsExist--;
                deleteItemArray(nums, numsExist, i);
            } else {
                i++;
            }
        }

        return numsExist;
    }

    public void deleteItemArray(int[] nums, int m, int i) {
        for (int j = i; j < m; j++) {
            nums[j]=nums[j+1];
        }
    }
}
