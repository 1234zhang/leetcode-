/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (43.19%)
 * Likes:    1108
 * Dislikes: 54
 * Total Accepted:    228K
 * Total Submissions: 518.6K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> result =new ArrayList<>();
       for (int i = 0; i < (1 << nums.length); i++) {
           List<Integer> contain = new ArrayList<>();
           int flag = i;
           for (int j = 0; j < nums.length; j++) {
               if(((flag >> j) & 1) == 1){
                    contain.add(nums[j]);
               }
           }
           Collections.sort(contain);
           if(!result.contains(contain)){
                result.add(contain);
           }
       }
       return result;
    }
}
// @lc code=end

