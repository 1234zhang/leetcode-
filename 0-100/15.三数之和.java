/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.49%)
 * Likes:    1561
 * Dislikes: 0
 * Total Accepted:    122.7K
 * Total Submissions: 499.9K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(left < right){
                List<Integer> contain = new ArrayList<>();
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    contain.add(nums[i]);
                    contain.add(nums[left]);
                    contain.add(nums[right]);
                    list.add(contain);
                while(left < right && nums[left] == nums[left + 1]) left++;
                while(left < right && nums[right] == nums[right - 1]) right --;
                left++;
                right--;
                }
                else if(sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }
            }
        }
        return list;
    }
}
// @lc code=end

 