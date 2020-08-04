package com.leetcode.simple;

import java.util.LinkedList;
import java.util.Queue;

public class S101 {
    /*
    101. 对称二叉树
    给定一个二叉树，检查它是否是镜像对称的。

    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
       / \
      2   2
     / \ / \
    3  4 4  3
     
    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
       / \
      2   2
       \   \
       3    3
     */
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static boolean isMirror(TreeNode root){
        if (root == null) {
            return true;
        }

        Queue<TreeNode> left = new LinkedList<>();
        left.add(root);
        Queue<TreeNode> right= new LinkedList<>();
        right.add(root);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode leftPeek = left.poll();
            TreeNode rightPeek = right.poll();
            if(leftPeek == null && rightPeek == null){
                continue;
            }
            if(leftPeek == null || rightPeek == null){
                return false;
            }
            left.add(leftPeek.left);
            left.add(leftPeek.right);
            right.add(rightPeek.right);
            right.add(rightPeek.left);
        }
        return left.isEmpty() && right.isEmpty();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}