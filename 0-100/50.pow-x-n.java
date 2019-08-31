/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (27.87%)
 * Likes:    920
 * Dislikes: 2244
 * Total Accepted:    344.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double result = 1;
        boolean negative = false;
        if(n < 0){
            negative = true;
            n = -n;
        }
        while(n != 0){
            if(n % 2 == 1){
                result *= x;
            }
            x *= x;
            n >>>= 1;
        }
        if(negative){
            return 1/result;
        }
        return result;
    }
}

/**
 * 这里有一个疑问， 为什么使用>> 会超时 而使用>>>不会超时
 */

