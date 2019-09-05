/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (36.24%)
 * Likes:    2464
 * Dislikes: 190
 * Total Accepted:    397.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int i = 0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length - 1 && right >= intervals[i + 1][0]){
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{left, right});
            i++;
        }
        return result.toArray(new int[0][]);
    }
}

