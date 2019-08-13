import java.util.ArrayList;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.97%)
 * Likes:    1831
 * Dislikes: 92
 * Total Accepted:    331.2K
 * Total Submissions: 974.3K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
import java.util.*;
class Solution {
    List<Integer> position = new ArrayList<>();
    int flag = 0;
    public int[] searchRange(int[] nums, int target) {
        flag = target;
        findTarget(nums, 0, nums.length - 1);
        int[] result = {-1,-1};
        if(position.isEmpty()){
            return result;
        }
        result[0] = Collections.min(position);
        result[1] = Collections.max(position);
        return result;
    }
    public void findTarget(int[] nums, int left, int right){
        int L = left;
        int R = right;
        if(left > right){
            return;
        }
        while(L <= R){
            int mid = (L + R)/2;
            if(nums[mid] == flag){
                position.add(mid);
                findTarget(nums, left, mid - 1);
                findTarget(nums, mid + 1, right);
                break;
            }else if(nums[mid]  > flag){
                R = mid - 1;
            }else if(nums[mid] < flag){
                L = mid + 1;
            }
        }
    }
}

