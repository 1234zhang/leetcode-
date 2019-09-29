/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (42.84%)
 * Likes:    1999
 * Dislikes: 175
 * Total Accepted:    360.3K
 * Total Submissions: 831.4K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution {
    public void sortColors(int[] nums) {
        int flag = nums[0];
        if(nums.length <= 1){
            return;
        }
        if(nums.length == 2){
            if(nums[0] > nums[1])
            exchange(nums, 0, nums.length - 1);
            return;
        }
        int begin = 0;
        int end = nums.length - 1;
        int result = end;
        while(begin != end){
            while(flag <= nums[end] && begin < end){end--;}
            while(flag >= nums[begin] && end > begin){begin++;}
            if(end > begin){
                exchange(nums, begin, end);
            }
        }
        exchange(nums, 0, begin);
        sort(nums, 0, begin - 1);
        sort(nums, begin + 1, result);
    }

    public void sort(int[] nums, int begin, int end){
        if(begin >= end){
            return;
        }
        int start = begin;
        int result = end;
        int flag = nums[start];
        while(begin != end){
            while(flag <= nums[end] && begin < end) end--;
            while(flag >= nums[begin] && begin < end) begin++;
            if(end > begin){
                exchange(nums, begin, end);
            }
        }
        exchange(nums, start, begin);
        sort(nums, start, begin - 1);
        sort(nums, begin + 1, result);
    }

    public void exchange(int[] nums, int begin, int end){
        int contain = nums[begin];
        nums[begin] = nums[end];
        nums[end] = contain;
    }
}

