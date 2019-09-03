/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (32.35%)
 * Likes:    2317
 * Dislikes: 224
 * Total Accepted:    299.2K
 * Total Submissions: 920.4K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        for (int i = 0; i <= nums[0]; i++) {
            if(judge(nums[i], nums)){
                return true;
            }
        }
        return false;
    }

    public boolean judge(int n, int[] nums){
        if(n >= nums.length - 1){
            return true;
        }
        for (int i = 0; i < nums[n]; i++) {
            if(judge(n + i + nums[n + i], nums)){
                return true;
            }
        }
        return false;
    }
}

