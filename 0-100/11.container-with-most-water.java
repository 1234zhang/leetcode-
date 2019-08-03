/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        int begin = 0, end = height.length - 1;
        int contain = Integer.MIN_VALUE;
        while(begin <= end){
            contain =  Math.max(contain, Math.min(height[begin],height[end]) * (end - begin));
            if(height[begin] < height[end]){
                begin++;
            }else{
                end--;
            }
        }
        return contain;
    }
}

