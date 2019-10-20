/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (50.98%)
 * Likes:    1121
 * Dislikes: 460
 * Total Accepted:    301K
 * Total Submissions: 583.1K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            result[0] = i + 1;
            if(numbers[i] > target){
                return null;
            }
            int j;
            if((j = findResult(numbers, i + 1, target - numbers[i])) > 0){
                result[1] = j + 1;
                return result;
            }
        }
        return null;
    }
    public int findResult(int[] nums, int begin, int target){
        int mid;
        int end = nums.length - 1;
        while(end >= begin){
            mid = (end + begin)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

