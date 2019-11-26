/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (61.91%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    12.5K
 * Total Submissions: 20.2K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    List<List<TreeNode>> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        helper(root, 0);
        List<Integer> result = new ArrayList<>();
        for(List<TreeNode> nodes : list){
            result.add(nodes.get(nodes.size() - 1).val);
        }
        return result;
    }
    public void helper(TreeNode root, int level){
        if(level == list.size()){
            list.add(new ArrayList<TreeNode>());
        }
        list.get(level).add(root);
        if(root.left != null){
            helper(root.left, level + 1);
        }
        if(root.right != null){
            helper(root.right, level + 1);
        }
    }
}
// @lc code=end

