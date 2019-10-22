/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (53.56%)
 * Likes:    2050
 * Dislikes: 179
 * Total Accepted:    449.5K
 * Total Submissions: 824.6K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

// @lc code=start
import java.util.*;
import java.util.Map.Entry;
class Solution {
    private HashMap<Integer, Integer> count(int[] nums){
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i : nums) {
            if(!result.containsKey(i)){
                result.put(i, 1);
            }else{
                result.put(i, result.get(i) + 1);
            }
        }
        return result;
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = count(nums);
        Map.Entry<Integer, Integer> entry = null;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if(entry == null || i.getValue() > entry.getValue()){
                entry = i;
            }
        }
        return entry.getKey();
    }
}
// @lc code=end

