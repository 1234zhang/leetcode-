/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (35.98%)
 * Likes:    330
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 116.6K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < len; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = len - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[right], nums[left]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if(sum < target) left++;
                    else if(sum > target) right--;
                }
            }
        }
        return list;
    }
}
// @lc code=end

