/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.49%)
 * Likes:    624
 * Dislikes: 0
 * Total Accepted:    55.5K
 * Total Submissions: 76.6K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<String> result = new ArrayList<>();
    int target = 0;
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return result;
        }
        target = n;
        helper("(", 1, 0);
        return result;
    }
    public void helper(String str, int left, int right){
        if(left == target && right == target){
            result.add(str);
        }
        if(right <= left){
            if(left < target){
                helper(str + "(", left + 1, right);
            }
            if(right < target){
                helper(str + ")", left, right + 1);
            }
        }
    }
}
// @lc code=end

