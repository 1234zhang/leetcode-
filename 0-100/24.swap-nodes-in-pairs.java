/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (45.74%)
 * Likes:    1290
 * Dislikes: 115
 * Total Accepted:    339.9K
 * Total Submissions: 743.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        int length = 2;
        if(head == null || head.next == null){
            return head;
        }
        ListNode second = head;
        ListNode first = head.next;
        while(first != null){
            if(length % 2 == 0){
                int flag = first.val;
                first.val = second.val;
                second.val = flag;
                first = first.next;
                second = second.next;
                length++;
            }else{
                first = first.next;
                second = second.next;
                length++;
            }
        }
        return head;
    }
}

