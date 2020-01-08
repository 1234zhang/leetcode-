/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (48.13%)
 * Likes:    1468
 * Dislikes: 0
 * Total Accepted:    140.3K
 * Total Submissions: 288.9K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    public int divide(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        int p = (left + right) / 2;
        int leftSum = divide(nums, left, p);
        int rightSum = divide(nums, p + 1, right);
        int corseSum = helper(nums, left, right, p);
        return Math.max(Math.max(leftSum, rightSum), corseSum);
    }
    public int helper(int[] nums, int left, int right, int mid){
        int current = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid; i >= left; i--){
            current += nums[i];
            leftSum = Math.max(current, leftSum);
        }
        current = 0;
        for(int i = mid + 1; i <= right; i++){
            current += nums[i];
            rightSum = Math.max(current, rightSum);
        }
        return rightSum + leftSum;
    }
}
// @lc code=end

