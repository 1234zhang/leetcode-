/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (35.63%)
 * Likes:    1514
 * Dislikes: 105
 * Total Accepted:    219.8K
 * Total Submissions: 605.7K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int[] nums = new int[n - m + 1];
        ListNode target = null;
        ListNode pos = head;
        for (int i = 1; i < m; i++) {
            pos = pos.next;
        }
        target = pos;
        for (int i = 0; i <= n - m; i++) {
            nums[i] = pos.val;
            pos = pos.next;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            target.val = nums[i];
            target = target.next;
        }
        return head;
    }
}
// @lc code=end

