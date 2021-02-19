package com.bhargo.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArrays {

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1Index = m;
        for (int i =0; i < n; i++) {
            int index = findIndexIn(nums1, m, nums2[i]);
            if (index > m) {
                nums1[m1Index++] = nums2[i];
            } else {
                shift(nums1, index, nums2[i]);
            }
        }
    }

    private static void shift(int[] nums1, int index, int num) {

    }

    private static int findIndexIn(int[] nums, int numsSize, int num) {
        int i =0;
        while (nums[i] < num){
            i++;
        }
        return i;
    }
}
