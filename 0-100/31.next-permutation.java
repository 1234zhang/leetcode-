/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.85%)
 * Likes:    2014
 * Dislikes: 645
 * Total Accepted:    258.2K
 * Total Submissions: 836.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(j > 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        resver(nums, i + 1);
    }
    public void resver(int[] nums, int start){
        int i = start;
        int j = nums.length - 1;
        while(j > i){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int flag = nums[i];
        nums[i] = nums[j];
        nums[j] = flag;
    }
}

