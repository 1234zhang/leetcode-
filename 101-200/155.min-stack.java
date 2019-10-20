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
    List<Integer> minVal;
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        minVal = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(x <= min){
            minVal.add(x);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(min == stack.peek()){
            minVal.remove(minVal.size() - 1);
            if(minVal.size() > 0){
                min = minVal.get(minVal.size() - 1);
                stack.pop();
            }
        }else{
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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

