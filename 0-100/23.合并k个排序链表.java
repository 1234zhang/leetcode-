/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.94%)
 * Likes:    397
 * Dislikes: 0
 * Total Accepted:    57.6K
 * Total Submissions: 120.2K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int left = 0;
        int right = lists.length - 1;
        while(right > 0){
            while(left < right){
                lists[left] = helper(lists[left], lists[right]);
                left++;
                right--;
            }
            left = 0;
        }
        return lists[0];
    }
    public ListNode helper(ListNode left, ListNode right){
        if(left == null || right == null){
            return left == null ? right : left;
        }
        ListNode flag = new ListNode(0);
        ListNode result = flag;
        while(left != null && right != null){
            if(left.val < right.val){
                flag.next = left;
                left = left.next;
            }else{
                flag.next = right;
                right = right.next;
            }
            flag = flag.next;
        }
        flag.next = left == null ? right : left;
        return result.next;
    }
}
// @lc code=end

