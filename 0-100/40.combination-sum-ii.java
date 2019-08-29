/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (42.80%)
 * Likes:    977
 * Dislikes: 50
 * Total Accepted:    240.6K
 * Total Submissions: 560.5K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int flag = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        flag = target;
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(candidates[i]);
            findResult(combination, candidates[i], candidates, i + 1);
        }
        return result;
    }
    public void findResult(List<Integer> combination, int sum, int[] candidates, int position){
        if(sum == flag){
            if(!result.contains(combination)){
                result.add(new ArrayList<>(combination));
                combination.remove(combination.size() - 1);
            }else{
                combination.remove(combination.size() - 1);
            }
        }else{
            for (int i = position; i < candidates.length; i++) {
                if(sum + candidates[i] <= flag){
                    combination.add(candidates[i]);
                    findResult(combination, sum + candidates[i], candidates, i + 1); 
                }
            }
            combination.remove(combination.size() - 1);
        }
    }
}

