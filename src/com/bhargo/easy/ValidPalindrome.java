package com.bhargo.easy;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */

public class ValidPalindrome {

    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String s) {
        return recur(s, 0, s.length()-1);
    }

    private static boolean recur(String str, int left, int right) {
        return false;
    }
}
