/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.18%)
 * Likes:    249
 * Dislikes: 0
 * Total Accepted:    45.1K
 * Total Submissions: 113.8K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length - 1 && right >= intervals[i + 1][0]){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            i++;
            list.add(new int[]{left, right});
        }
        return list.toArray(new int[0][]);
    }
}
// @lc code=end

