/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (38.18%)
 * Likes:    253
 * Dislikes: 0
 * Total Accepted:    46.5K
 * Total Submissions: 121.9K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return new int[]{-1,-1};
        }
        if(len == 1 && nums[0] == target){
            return new int[]{0,0};
        }
        int flag = search(nums, 0, len - 1, target);
        if(flag >= 0){
            int left = flag;
            int right = flag;
            while(left > 0 && nums[left - 1] == target) left--;
            while(right < len - 1 && nums[right + 1] == target) right++;
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }
    public int search(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

