/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.31%)
 * Likes:    1004
 * Dislikes: 203
 * Total Accepted:    228.3K
 * Total Submissions: 753.2K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

 import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(); 
        if(nums.length < 4 || nums == null){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int flag = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int L = j + 1;
                int R = nums.length - 1;
                while(L < R){
                    int sum = nums[j] + nums[L] + nums[R];
                    if(sum == flag){
                        result.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while(L < R && nums[L] == nums[L + 1]) L++;
                        while(L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    }else if(sum < flag){
                        L++;
                    }else if(sum > flag){
                        R--;
                    }
                }
            }
        }
        return result;
    }
}

