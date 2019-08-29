/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (56.56%)
 * Likes:    2280
 * Dislikes: 69
 * Total Accepted:    416.6K
 * Total Submissions: 734.6K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(nums[i]);
            getResult(combination, nums);
        }
        return result;
    }
    public void getResult(List<Integer> combination, int[] nums){
        if(combination.size() == nums.length){
            result.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(!combination.contains(nums[i])){
                    combination.add(nums[i]);
                    getResult(combination, nums);
                }
            }
            combination.remove(combination.size() - 1);
        }
    }
}

