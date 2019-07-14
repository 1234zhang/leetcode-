/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findDepth(root, 1);
    }
    public int findDepth(TreeNode root, int depth){
        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(root.right == null && root.left == null){
            return depth;
        }
        if(root.right != null){
            right = findDepth(root.right, depth + 1);
        }
        if(root.left != null){
            left = findDepth(root.left,depth + 1);
        }
        return Math.min(right,left);
    }
}

