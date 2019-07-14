import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
     Map<Integer,Integer> map = new HashMap<>();
     for (int i = 0; i < nums.length; i++){
         int key = target - nums[i];
        if(map.containsKey(key)){
            return new int[]{map.get(key),i};
        }
        map.put(nums[i],i);
    }
     return null;
    }
}
/**
 * towsum算法笔记：map.compainsKey(key)方法是用来检查是否有map中存在以key为
 * 索引的value。如果存在，则说名target减去num[i]存在，则有key+nums[i]=target
 * 的值存在。算法时间复杂度为O(n).只遍历了一遍数组。
 * 
 */

