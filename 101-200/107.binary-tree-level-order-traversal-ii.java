
/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrderBottom = new ArrayList<>();
        if(root == null){
            return levelOrderBottom;
        }
        queue.offer(root);
        int size;
        while(!queue.isEmpty()){
            List<Integer> levelNum = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNum.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            levelOrderBottom.add(levelNum);
        }
        Collections.reverse(levelOrderBottom);
        return levelOrderBottom;
    }
}

