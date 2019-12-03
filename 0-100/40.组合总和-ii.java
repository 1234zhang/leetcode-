/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (58.27%)
 * Likes:    171
 * Dislikes: 0
 * Total Accepted:    30.6K
 * Total Submissions: 52.2K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int flag = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0){
            return result;
        }
        flag = target;
        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++){
            List<Integer> list = new ArrayList<Integer>();
            list.add(candidates[i]);
            helper(candidates, i + 1, candidates[i], list);
        }
        return result;
    }
    public void helper(int[] nums, int start, int sum, List<Integer> list){
        if(sum == flag){
            if(!result.contains(list)){
                result.add(new ArrayList(list));
            }
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(sum + nums[i] <= flag){
                list.add(nums[i]);
                helper(nums, i + 1, sum + nums[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

