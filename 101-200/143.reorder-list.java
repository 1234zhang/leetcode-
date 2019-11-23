/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (31.73%)
 * Likes:    1202
 * Dislikes: 89
 * Total Accepted:    182.9K
 * Total Submissions: 551.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
import java.util.*;
class Solution {
    public void reorderList(ListNode head) {
        int count = 0;
        if(head == null){
            return ;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while(head != null){
            stack.push(head);
            head = head.next;
            count++;
        }
        int mid = count/2;
        while(mid >= 0){
            stack.peek().next = node.next;
            node.next = stack.peek();
            node = stack.peek().next;
            stack.pop();
            mid--;
        }
        node.next = null;
    }
}
// @lc code=end

