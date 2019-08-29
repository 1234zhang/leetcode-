/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (49.90%)
 * Likes:    2272
 * Dislikes: 70
 * Total Accepted:    377.2K
 * Total Submissions: 754K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int flag = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        flag = target;
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(candidates[i]);
            findResult(combination, candidates[i], candidates, i);
        }
        return result;
    }
    public void findResult(List<Integer> combination, int sum, int[] candidates, int position){
        if(sum == flag){
            result.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        }else{
            for (int i = position; i < candidates.length; i++) {
                if(sum + candidates[i] <= flag){
                    combination.add(candidates[i]);
                    findResult(combination, sum + candidates[i], candidates, i); 
               }
            }
            combination.remove(combination.size() - 1);
        }
    }
}

