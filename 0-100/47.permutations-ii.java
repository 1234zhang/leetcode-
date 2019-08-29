/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (41.54%)
 * Likes:    1142
 * Dislikes: 46
 * Total Accepted:    262.9K
 * Total Submissions: 631.3K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> combiantion = new ArrayList<>();
            List<Integer> position = new ArrayList<>();
            combiantion.add(nums[i]);
            position.add(i);
            if(i + 1 < nums.length && nums[i] == nums[i + 1]) continue;
            getResult(combiantion, nums, position);
        }
        return result;
    }
    public void getResult(List<Integer> combination, int[] nums, List<Integer> position){
        if(combination.size() == nums.length){
            if(!result.contains(combination)){
                result.add(combination);
            }
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(!position.contains(i)){
                    position.add(i);
                    combination.add(nums[i]);
                    getResult(new ArrayList<>(combination), nums, position);
                    int length = combination.size();
                    position.remove(length - 1);
                    combination.remove(length - 1);
                }
            }
        }
    }
}

