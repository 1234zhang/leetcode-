/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (58.36%)
 * Likes:    729
 * Dislikes: 0
 * Total Accepted:    144.1K
 * Total Submissions: 246.6K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode result = new ListNode(0);
        ListNode flag = result;
        while(l2 != null && l1 != null){
            result.next = l1.val < l2.val ? l1 : l2;
            result = result.next;
            if(l1.val < l2.val){
                l1 = l1.next;
            }else{
                l2 = l2.next;
            }
        }
        result.next = l1 == null ? l2 : l1;
        return flag.next;
    }
}
// @lc code=end

