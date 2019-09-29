/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (48.95%)
 * Likes:    941
 * Dislikes: 55
 * Total Accepted:    229.2K
 * Total Submissions: 458.9K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k > n){
            return result;
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(i);
            combination(combination, i, n, k);
        }
        return result;
    }

    public void combination(List<Integer> combination, int i, int n, int k){
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        }else{
            for (int j = i + 1; j <= n; j++) {
                combination.add(j);
                combination(combination, j, n, k);
            }
            combination.remove(combination.size() - 1);
        }
    }
}

