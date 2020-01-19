/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (37.22%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    84K
 * Total Submissions: 224.9K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        long end = x / 2 + 1;
        long start = 0;
        while(start < end){
            // 这里要向上取整。如果向下取证的话会死循环。
            long mid = (start + end + 1) / 2;
            if(mid * mid == x){
                return (int)mid;
            }
            if(mid*mid > x){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        return (int)start;

    }
}
// @lc code=end

