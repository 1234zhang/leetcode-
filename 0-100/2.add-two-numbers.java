/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = (l1.val + l2.val)/10;
        ListNode result = new ListNode((l1.val + l2.val)%10);
          ListNode head = result;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            result.next = new ListNode((x + y + carry)%10);
            result = result.next;
            carry = (x + y + carry)/10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry != 0){
            result.next = new ListNode(carry);
        }
        return head;
     }
}

