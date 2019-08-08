/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (54.50%)
 * Likes:    3031
 * Dislikes: 189
 * Total Accepted:    367.8K
 * Total Submissions: 655.5K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
import java.util.*;
class Solution {
    List<String> result = new ArrayList<>();
    int flag = 0;
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return result;
        }
        int left = 0;
        int right = 0;
        flag = n;
        backtrack("", left, right);
        return result;
    }
    public void backtrack(String combination, int left, int right){
        if(right > left){
            return;
        }
        if(right == flag && left == flag){
            result.add(combination);
        }
        if(left < flag){
            backtrack(combination + "(", left + 1, right);
        }        
        backtrack(combination + ")", left, right + 1);
    }
}

