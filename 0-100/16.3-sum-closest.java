/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.01%)
 * Likes:    1219
 * Dislikes: 88
 * Total Accepted:    366.2K
 * Total Submissions: 799.8K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE - target;
        int minDeff = Integer.MAX_VALUE;
        if(nums.length < 3 || nums == null){
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == target){
                    return sum;
                }else if(sum > target){
                    R--;
                }else{
                    L++;
                }
                int diff = Math.abs(sum - target);
                if(diff < minDeff){
                    minDeff = diff;
                    result = sum;
                }
            }
        }
        return result;
    }
}

