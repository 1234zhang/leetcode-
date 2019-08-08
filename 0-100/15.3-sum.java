/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.87%)
 * Likes:    3644
 * Dislikes: 399
 * Total Accepted:    534.9K
 * Total Submissions: 2.2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length <= 2 || nums == null){
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = length - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    List<Integer> ans = Arrays.asList(nums[i],nums[L],nums[R]);
                    while(R > L && nums[L] == nums[L + 1]) L++;
                    while(R > L && nums[R] == nums[R - 1]) R--;
                    R--;
                    L++;
                    res.add(ans);
                }else if(sum > 0){
                    R--;
                }else if(sum < 0){
                    L++;
                }
            }
        }
        return res;
    }
}

