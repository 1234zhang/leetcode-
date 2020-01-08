/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (35.98%)
 * Likes:    89
 * Dislikes: 0
 * Total Accepted:    13.2K
 * Total Submissions: 36.2K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int index = 0, len = intervals.length;
        List<int[]> list = new LinkedList<>();

        while(index < len && newStart > intervals[index][0]){
            list.add(intervals[index++]);
        }
        int[] interval = new int[2];
        if(list.isEmpty() || list.get(list.size() - 1)[1] < newStart){
            list.add(newInterval);
        }else{
            interval = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            interval[1] = Math.max(interval[1], newEnd);
            list.add(interval);
        }
        while(index < len){
            interval = intervals[index++];
            int start = interval[0], end = interval[1];
            if(list.get(list.size() - 1)[1] < start){
                list.add(interval);
            }else{
                interval = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                interval[1] = Math.max(interval[1], end);
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
// @lc code=end

