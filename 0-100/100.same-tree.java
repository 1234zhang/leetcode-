/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean flag1 = isSameTree(p.left, q.left);
        boolean flag2 = isSameTree(p.right,q.right);
        if(flag1 && flag2){
            return true;
        }else{
            return false;
        }
    }
}

