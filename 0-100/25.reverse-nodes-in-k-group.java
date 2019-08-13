import java.util.LinkedList;

/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (37.37%)
 * Likes:    1303
 * Dislikes: 263
 * Total Accepted:    197.8K
 * Total Submissions: 529.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
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
import java.util.*;
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Queue<ListNode> nodeQueue = new LinkedList<>();
        Stack<Integer> nums = new Stack<Integer>();
        ListNode result = head;
        if(head == null){
            return head;
        }
        int length = 0;
        while(head != null){
            if(length % k == 0 && length != 0){
                while(!nodeQueue.isEmpty()){
                    ListNode node = nodeQueue.poll();
                    node.val = nums.pop();
                }
                nodeQueue.offer(head);
                nums.push(head.val);
                head = head.next;
                length++;
            }else{
                nodeQueue.offer(head);
                nums.push(head.val);
                head = head.next;
                length++;
            }
        }
        if(length % k == 0 && length != 0){
            while(!nodeQueue.isEmpty()){
                ListNode node = nodeQueue.poll();
                node.val = nums.pop();
            }
        }
        return result;
    }
}

