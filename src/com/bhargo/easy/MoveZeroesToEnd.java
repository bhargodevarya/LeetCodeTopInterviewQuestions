package com.bhargo.easy;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,4,2,4,0,0,3,0,5,1,0};
        moveZeroesMaintainOrder(nums);
        for (int num : nums)System.out.println(num);

    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int rIndex = nums.length-1;
        for(int i =0; i < nums.length; i++) {
            if (nums[i] == 0 && rIndex > i) {
                swap(nums, i, rIndex);
                i--;
                rIndex--;
            }
        }
    }

    public static void moveZeroesMaintainOrder(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int nonZeroIndex = -1;
        for(int i =0; i < nums.length; i++) {
            if (i != -1)
                nonZeroIndex = i+1;
            if (nums[i] == 0 && nonZeroIndex != -1) {
                nonZeroIndex= findNonZeroIndex(nums, nonZeroIndex);
                if (nonZeroIndex == -1)
                    continue;
                swap(nums, i, nonZeroIndex);
            }
        }
    }

    private static int findNonZeroIndex(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != 0)
                return i;
        }
        return -1;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
