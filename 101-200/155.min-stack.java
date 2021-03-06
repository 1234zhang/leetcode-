/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (38.10%)
 * Likes:    2193
 * Dislikes: 240
 * Total Accepted:    360.6K
 * Total Submissions: 919K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 * 
 * 
 */

// @lc code=start
import java.util.*;
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> supports;
    Stack<Integer> stack;
    public MinStack() {
        supports = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(supports.size() == 0 || x <= supports.peek()){
            stack.push(x);
            supports.push(x);
        }else{
            stack.push(x);
            supports.push(supports.peek());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            supports.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return supports.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

