/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (46.04%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    40.1K
 * Total Submissions: 87.1K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    int target = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                helper(grid, i, j, flag, true);
            }
        }
        return target;
    }
    public void helper(char[][] grid, int i, int j, boolean[][] flag, boolean isFirst){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1' && !flag[i][j]){
            flag[i][j] = true;
            if(isFirst){
                target++;
                isFirst = false;
            }
            helper(grid, i + 1, j, flag, isFirst);
            helper(grid, i, j + 1, flag, isFirst);
            helper(grid, i - 1, j, flag, isFirst);
            helper(grid, i, j - 1, flag, isFirst);
        }
    }
}
// @lc code=end

