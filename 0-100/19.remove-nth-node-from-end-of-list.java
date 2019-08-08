/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.19%)
 * Likes:    2002
 * Dislikes: 150
 * Total Accepted:    424.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
import java.util.Map;
import java.util.HashMap;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int length = 0;
        ListNode node = head;
        while(node != null){
            nodeMap.put(length, node);
            node = node.next;
            length++;
        }
        if(n > length){
            return head;
        }
        if(length == n){
            return head = head.next;
        }
        node = nodeMap.get(length - n - 1);
        node.next = node.next.next;
        return head;
    }
}

