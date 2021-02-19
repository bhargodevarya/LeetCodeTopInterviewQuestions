package com.bhargo.medium;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {

        System.out.println(search(new int[]{1,2,3,4,5,6}, 4));

    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        if (nums.length == 2) {
            if (nums[0] == target)
                return 0;
            else if(nums[1] == target)
                return 1;
            else
                return -1;
        }

        int rotatedIndex = findIndex(nums, 0, nums.length-1);
        if (rotatedIndex == -1) {
            return binarySearch(nums, 0, nums.length-1, target);
        }
        if (target == nums[rotatedIndex])
            return rotatedIndex;

        int res = binarySearch(nums, 0, rotatedIndex, target);

        return res == -1 ? binarySearch(nums, rotatedIndex, nums.length-1, target) : res;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end || start < 0 || end > nums.length-1)
            return -1;

        if (start == end) {
            if (nums[start] == target)
                return start;
            else
                return -1;
        }

        int pivot = (start+end)/2;
        if (nums[pivot] == target)
            return pivot;
        else if (nums[pivot] > target) {
            return binarySearch(nums, start, pivot-1, target);
        }
        return binarySearch(nums, pivot+1, end, target);
    }

    private static int findIndex(int[] nums, int start, int end) {
        if (start > end || start < 0 || end > nums.length-1)
            return -1;

        if (start == end)
            return -1;

        int pivot = (start+end)/2;

        if (pivot == 0)
            return -1;

        if (nums[pivot] < nums[pivot+1] && nums[pivot] > nums[pivot-1]) {
            if (nums[pivot] < nums[end]) {
                return findIndex(nums, start, pivot-1);
            } else {
                return findIndex(nums, pivot+1, end);
            }
        }
        return nums[pivot] < nums[pivot+1] ? pivot : pivot+1;
    }
}
