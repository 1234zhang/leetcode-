/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (36.93%)
 * Likes:    316
 * Dislikes: 0
 * Total Accepted:    28.7K
 * Total Submissions: 77.6K
 * Testcase Example:  '[1,2,0]'
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] < n && nums[i] != i){
                if(nums[nums[i] % n] == nums[i] % n){
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] %n];
                nums[temp % n] = nums[i];
            }
        }
        for(int i = 1; i < n; i++){
            if(i != nums[i]){
                return i;
            }
        }
        return nums[0] == n ? n + 1 : n;
    }
}
// @lc code=end

