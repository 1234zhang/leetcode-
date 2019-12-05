/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.70%)
 * Likes:    463
 * Dislikes: 0
 * Total Accepted:    61.1K
 * Total Submissions: 83.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        helper(nums, 0);
        return result;
    }
    public void helper(int[] nums, int flag){
        if(flag == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
            result.add(list);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = flag; i < nums.length; i++){
            if(i == flag || !set.contains(nums[i])){
                set.add(nums[i]);
                swap(nums, i, flag);
                helper(nums, flag + 1);
                swap(nums, i, flag);
            }
        }
    }
    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
// @lc code=end

