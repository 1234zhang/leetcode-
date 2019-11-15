/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.37%)
 * Likes:    1068
 * Dislikes: 23
 * Total Accepted:    174.5K
 * Total Submissions: 420.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */

// @lc code=start
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        TreeNode root = helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public TreeNode helper(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd && postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == post[postEnd]){
                root.left = helper(in, post, inStart, i - 1, postStart, postStart + i - inStart - 1);
                root.right = helper(in, post, i + 1, inEnd, postStart + i - inStart, postEnd - 1);
            }
        }
        return root;
    }
}
// @lc code=end

