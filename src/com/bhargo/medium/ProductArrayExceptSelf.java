package com.bhargo.medium;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i =1; i < nums.length; i++) {
            result[i] = result[i-1]*nums[i-1];
        }

        int prod = nums[nums.length-1];
        for (int i = nums.length-2; i >= 1; i--) {
            result[i]=prod*result[i];
            prod= prod*nums[i];
        }

        result[0] = prod;

        for (int in : result) { System.out.println(in);}
        return result;
    }
}
