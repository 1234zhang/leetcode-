/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (25.14%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    6.2K
 * Total Submissions: 24.7K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 
 * 示例 1:
 * 
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 
 * 
 * 示例 2:
 * 
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 
 * 示例 3:
 * 
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator == 0){
            return "0";
        }
        if(numerator < 0 ^ denominator < 0){
            sb.append("-");
        }
        long num1 = Math.abs(Long.valueOf(numerator));
        long num2 = Math.abs(Long.valueOf(denominator));

        sb.append(num1 / num2);
        long re = num1 % num2;
        if(re == 0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while(re != 0){
            if(map.containsKey(re)){
                sb.insert(map.get(re), "(");
                sb.append(")");
                break;
            }
            map.put(re, sb.length());
            re *= 10;
            sb.append(re / num2);
            re = re % num2;
        }
        return sb.toString();
    }
}
// @lc code=end

