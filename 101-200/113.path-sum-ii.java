/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (41.61%)
 * Likes:    1126
 * Dislikes: 42
 * Total Accepted:    265.1K
 * Total Submissions: 620.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    List<List<Integer>> result = new ArrayList();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        List<Integer> contain = new ArrayList<Integer>();
        contain.add(root.val);
        target = sum;
        helper(root, root.val, contain);
        return result;
    }
    public void helper(TreeNode root, int flag, List<Integer> contain){
        if(flag == target && root.right == null && root.left == null){
            result.add(new ArrayList(contain));
            
            return;
        }else{
            if(root.left != null){
                contain.add(root.left.val);
                helper(root.left, flag + root.left.val, contain);
                contain.remove(contain.size() - 1);

           }
            if(root.right != null){
                contain.add(root.right.val);
                helper(root.right, flag + root.right.val, contain);
                contain.remove(contain.size() - 1);

            }
        }

    }
}
// @lc code=end


