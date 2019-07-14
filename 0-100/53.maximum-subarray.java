/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = nums[0];
        int max = p[0];

        for (int i = 1; i < n; i++){
            p[i] = nums[i] + (p[i-1] > 0 ? p[i-1] : 0);
            max = Math.max(max,p[i]);
        }
        return max;
    }
}
/**
 * NOTE:
 *  动态规划问题的核心思想：记住已经解决过的问题。
 */

