/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.49%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    29.9K
 * Total Submissions: 53.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        helper(nums, 0);
        return result;
    }
    public void helper(int[] nums, int flag){
        if(flag == nums.length){
            List<Integer> list = new ArrayList();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
        }
        Set<Integer> set = new HashSet();
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

