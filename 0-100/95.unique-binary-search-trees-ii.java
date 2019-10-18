/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (36.50%)
 * Likes:    1518
 * Dislikes: 128
 * Total Accepted:    155.9K
 * Total Submissions: 418.5K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> result = findResult(1, n);
                System.out.println();
                return result;
    }

    public List<TreeNode> findResult(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end){
            result.add(null);
            return result;
        }
        if(start == end){
            TreeNode root = new TreeNode(end);
            result.add(root);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = findResult(start, i - 1);
            List<TreeNode> right = findResult(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode  rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightNode;
                    root.left = leftNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
// @lc code=end

