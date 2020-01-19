/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.21%)
 * Likes:    427
 * Dislikes: 0
 * Total Accepted:    57K
 * Total Submissions: 157.4K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
    public int findRotatedIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid == nums.length - 1){
                return nums.length - 1;
            }
            if(nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            if(nums[mid] < nums[left]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }
    public int search(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int rotatedIndex = findRotatedIndex(nums);
        if(target == nums[rotatedIndex]){
            return rotatedIndex;
        }
        if(rotatedIndex == 0){
            return search(nums, 0, len - 1, target);
        }
        if(target < nums[0]){
            return search(nums, rotatedIndex, len - 1, target);
        }
        return search(nums, 0, rotatedIndex, target);
    }
}
// @lc code=end

