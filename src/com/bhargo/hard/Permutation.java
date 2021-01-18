package com.bhargo.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutation {

    public static void main(String[] args) {
        permute(new int[]{1,2,3}).stream().forEach(item -> {
            for (int in : item) System.out.print(in);
            System.out.println();
        });
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recur(nums, 0, nums.length-1, result);
        return result;
    }

    private static void recur(int[] nums, int left, int right, List<List<Integer>> result) {
        if (left == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);

        }
        for (int in =0; in <= right; in++) {
            swap(nums, left, in+left);
            recur(nums, left+1, right-1, result);
            swap(nums, left, in+left);
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
