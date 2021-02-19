package com.bhargo.easy;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static void main(String[] args) throws IOException {
        System.out.println(containsDuplicate(readFromFile()));
    }

    public static boolean containsDuplicate(List<Integer> nums) {
        for (int i =0; i < nums.size()-1; i++) {
            int current = nums.get(i);
             if (find(nums, current, i, i+1, nums.size()-1))
                 return true;
        }
        return false;
    }

    static List<Integer> readFromFile() throws IOException {
        File file = new File("P:\\code\\github\\LeetCodeTopInterviewQuestions\\src\\com\\bhargo\\easy\\file.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();
        String[] strings = string.split(",");
        return Arrays.stream(strings).map(item -> Integer.valueOf(item)).collect(Collectors.toList());
    }

    private static boolean find(List<Integer> nums, int current, int currentIndex, int s, int e) {
        if (s <0 || e > nums.size()-1)
            return false;

        if (s == e)
            return nums.get(s) == current;

        if (s > e)
            return false;

        int start = s, end = e;
        int mid = (start + end)/2;

        if (mid == currentIndex)
            return false;

        if (current == nums.get(mid))
            return true;

        if (find(nums, currentIndex, current, mid+1, end))
            return true;
        else
            return find(nums, currentIndex, current, mid-1, start);
    }
}
