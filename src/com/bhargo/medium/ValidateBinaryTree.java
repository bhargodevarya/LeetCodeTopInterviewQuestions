package com.bhargo.medium;

import com.bhargo.ds.TreeNode;

public class ValidateBinaryTree {

    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);

        six.left = three;six.right = seven;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        five.left = four;five.right = six;



        TreeNode min = new TreeNode(Integer.MIN_VALUE);
        min.right = new TreeNode(Integer.MAX_VALUE);

        System.out.println(recur(five).flag);

        System.out.println(Integer.MIN_VALUE);

    }

    public static result recur(TreeNode root) {
        if (root == null)
            return null;

        result left, right;

        left = recur(root.left);
        right = recur(root.right);

        if (left == null && right == null)
            return new result(root.val, root.val, true);

        if (left != null && right != null) {
            boolean b = left.flag && right.flag && root.val > left.max && root.val > left.min && root.val < right.min && root.val < right.max;
            return new result(Math.min(root.val, Math.min(left.min, right.min)), Math.max(root.val, Math.max(left.max, right.max)), b);
        }

        if (left == null) {
            return new result(Math.min(root.val, right.min), Math.max(root.val, right.max), right.flag && root.val < root.right.val && root.val < right.min);
        }

        return new result(Math.min(root.val, left.min), Math.max(root.val, left.max), left.flag && root.val > root.left.val && root.val > left.max);
    }

    static class result {
        Integer min, max;
        boolean flag;

        public result(Integer min, Integer max, boolean flag) {
            this.min = min;
            this.max = max;
            this.flag = flag;
        }
    }
}
