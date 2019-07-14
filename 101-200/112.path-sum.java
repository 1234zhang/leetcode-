/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        int flag = findPath(root,0,sum);
        if(flag == 0){
            return false;
        }else{
            return true;
        }
    }
    public int findPath(TreeNode root, int pathSum, int sum){
        int right = 0;
        int left = 0;
        pathSum += root.val;
        if(root.right == null && root.left == null && pathSum == sum){
            return 1;
        }
        if(root.right != null){
            right = findPath(root.right, pathSum, sum);
        }
        if(root.left != null){
            left = findPath(root.left,pathSum,sum);
        }
        if(left == 1 && right == 1){
            return 1;
        }
        return left^right;
    }
}

