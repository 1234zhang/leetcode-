/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (28.15%)
 * Likes:    2145
 * Dislikes: 526
 * Total Accepted:    308.7K
 * Total Submissions: 1M
 * Testcase Example:  '{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}'
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer
 * points to itself.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You must return the copy of the given head as a reference to the cloned
 * list.
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public void copy(Node head){
        Node node = head;
        while(node != null){
            Node copy = new Node();
            copy.val = node.val;
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
    }
    public void reConnect(Node head){
        Node node = head;
        while(node != null){
            Node copy = node.next;
            if(node.random != null){
                copy.random = node.random.next;
            }
            node = copy.next;
        }
    }
    public Node result(Node head){
        Node node = head;
        Node copy = new Node();
        Node copyHead = copy;
        while(node != null){
            copy.next = node.next;
            copy = copy.next;
            node.next = copy.next;
            node = node.next;
        }
        return copyHead.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        copy(head);
        reConnect(head);
        return result(head);
    }
}
// @lc code=end

