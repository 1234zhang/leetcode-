/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (39.37%)
 * Likes:    188
 * Dislikes: 0
 * Total Accepted:    38.2K
 * Total Submissions: 96.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        ListNode node = head;
        ListNode result = new ListNode(0);
        ListNode point = result;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        node = head;
        if(k % len == 0){
            return head;
        }else{
           while(node.next != null){
               node = node.next;
           }
           node.next = head;
           int flag = len - (k % len) - 1;
           ListNode slow = head;
           ListNode fast = head.next;
           while(flag > 0){
               slow = slow.next;
               fast = fast.next;
               flag--;
           }
           slow.next = null;
           head = fast;
        }
        return head;
    }
}
// @lc code=end

