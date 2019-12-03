/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (67.40%)
 * Likes:    452
 * Dislikes: 0
 * Total Accepted:    47.8K
 * Total Submissions: 71K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int flag = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return result;
        }
        flag = target;
        for(int i = 0; i < candidates.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            helper(candidates,i, candidates[i], list);
        }
        return result;
    }
    public void helper(int[] nums, int start, int sum, List<Integer> list){
        if(sum == flag){
            result.add(new ArrayList(list));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(sum + nums[i] <= flag){
                list.add(nums[i]);
                helper(nums, i, sum + nums[i],list);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

