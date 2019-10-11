/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (37.99%)
 * Likes:    823
 * Dislikes: 218
 * Total Accepted:    180.4K
 * Total Submissions: 467.3K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode more = new ListNode(0);
        ListNode less = new ListNode(0);
        ListNode flag = more;
        ListNode result = less;
        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
                head = head.next;
            }else{
                more.next = head;
                more = more.next;
                head = head.next;
            }
        }
        more.next = null;
        less.next = flag.next;
        return result.next;
    }

}
// @lc code=end

