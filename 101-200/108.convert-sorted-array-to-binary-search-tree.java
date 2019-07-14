/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

//  Definition for a binary tree node.
//import java.io.*;
//import java.util.*;
 //class TreeNode {
//      int val;
//      TreeNode left;
 //     TreeNode right;
  //    TreeNode(int x) { val = x; }
  //}
 
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
         return buildBST(nums,0,nums.length - 1);
    }
    public TreeNode buildBST(int[] nums, int begin, int end){
        if(begin > end){
            return null;
        }
        if(begin == end){
            return new TreeNode(nums[begin]);
        }
        int mid = begin + (int)Math.ceil((double)(end - begin)/2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, begin, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
