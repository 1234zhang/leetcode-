/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (33.22%)
 * Likes:    1483
 * Dislikes: 0
 * Total Accepted:    226.8K
 * Total Submissions: 682.6K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        if(x == Integer.MAX_VALUE){
            return 0;
        }
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = -x;
        }
        StringBuffer sb = new StringBuffer();
        while(x > 0){
            sb.append(x % 10);
            x = x / 10;
        }
        long num = Long.valueOf(sb.toString());
        if(num > Integer.MAX_VALUE){
            if(negative){
                return 0;
            }else{
                return 0;
            }
        }
        if(negative){
            return -(int)num;
        }
        return (int) num;
    }
}
// @lc code=end

