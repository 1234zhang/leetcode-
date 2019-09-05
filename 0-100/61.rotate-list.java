import java.util.Stack;

/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (27.69%)
 * Likes:    698
 * Dislikes: 869
 * Total Accepted:    210.2K
 * Total Submissions: 754.5K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;1
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        Stack<ListNode> node = new Stack<>();
        ListNode list = head;
        ListNode result = head;
        while(list != null){
            node.push(list);
            list = list.next;
            count++;
        }
        if(count == 0){
            return head;
        }
        k = k % count;
        if(k == 0 || count <= 1){
            return head;
        }else{
            for (int i = 0; i < k; i++) {
                ListNode top = node.pop();
                top.next = result;
                result = top;
                node.peek().next = null;
            }
        }
        return result;
    }
}

