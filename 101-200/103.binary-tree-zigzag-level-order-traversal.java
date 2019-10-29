/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (42.63%)
 * Likes:    1118
 * Dislikes: 65
 * Total Accepted:    240.9K
 * Total Submissions: 563.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
import java.util.*;



class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return result;
        }
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);
       helper(stack, 0);
       return result;
    }
    public void helper(Stack<TreeNode> stack, int level){
        if(stack.size() == 0){
            return;
        }
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        
        Stack<TreeNode> flag = new Stack<>();
        if(level % 2 == 0){
            while(stack.size() != 0){
                TreeNode root = stack.pop();
                result.get(level).add(root.val);
                if(root.left != null){
                    flag.push(root.left);
                }
                if(root.right != null){
                    flag.push(root.right);
                }
            }
        }else{
            while(stack.size() != 0){
                TreeNode root = stack.pop();
                result.get(level).add(root.val);
                if(root.right != null){
                    flag.push(root.right);
                }
                if(root.left != null){
                    flag.push(root.left);
                }
               
        }
    }
    helper(flag, level + 1);
}

}
// @lc code=end

