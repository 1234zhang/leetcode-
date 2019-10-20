/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
/**
 * QUESTION：Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * 
 */
/**
 * NOTE：
 * 该题采用了异或赋值操纵符
 * a^=b => a = a^b 
 * 两个相同的数异或为0
 * 0 异或上任意一个数等于这个数本身
 */
