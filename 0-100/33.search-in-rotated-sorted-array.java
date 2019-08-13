/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (33.07%)
 * Likes:    2744
 * Dislikes: 341
 * Total Accepted:    455.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int reverposition = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]){
                reverposition = mid;
                System.out.println(mid);
                break;
            }
            if((nums[left] > nums[mid]) && (nums[mid] < nums[right]) ){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        int leftPart = findTarget(nums, 0, reverposition, target);
        int rightPart = findTarget(nums,reverposition + 1, nums.length - 1, target);
        if(leftPart >= 0){
            return leftPart;
        }else if(rightPart >= 0){
            return rightPart;
        }else {
            return -1;
        }
    }

    public int findTarget(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = (right + left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}

