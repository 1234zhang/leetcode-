/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid = 0;
        int begin = 0;
        int end = nums.length-1;
        while(begin < end){
            mid = (begin + end)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) begin = mid + 1;
            else if(nums[mid] > target) end = mid - 1;
        }
        if(target > nums[begin]){
            return begin + 1;
        }else{
            return begin;
        }
    }

}

