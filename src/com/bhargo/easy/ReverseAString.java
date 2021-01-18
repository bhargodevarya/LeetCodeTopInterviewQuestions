package com.bhargo.easy;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseAString {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};
        reverseString(arr);
        for (char c : arr) { System.out.println(c);}
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        char temp = 'a';
        for(int i=0; i <s.length/2; i++) {
            temp = s[i];
            s[i] = s[s.length -1 -i];
            s[s.length -1 -i] = temp;
        }
    }
}
