/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (66.78%)
 * Likes:    270
 * Dislikes: 0
 * Total Accepted:    19.2K
 * Total Submissions: 28.7K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        boolean[] flag = new boolean[n];
        for(char[] str : chars){
            Arrays.fill(str, '.');
        }
        helper(chars, flag, 0);
        return result;
    }
    public void helper(char[][] chars, boolean[] flag, int row){
        if(row == flag.length){
            ArrayList<String> list = new ArrayList<>();
            for(char[] str : chars){
                list.add(new String(str));
            }
            result.add(list);
            return;
        }
        for(int i = 0; i < flag.length; i++){
            if(isValid(chars, row, i) && !flag[i]){
                flag[i] = true;
                chars[row][i] = 'Q';
                helper(chars, flag, row + 1);
                flag[i] = false;
                chars[row][i] = '.';
            }
        }
    }
    public boolean isValid(char[][] chars, int row, int clomn){
        for(int i = row - 1, j = clomn - 1; i >= 0 && j >= 0; i--, j--){
            if(chars[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = clomn + 1; i >= 0 && j < chars.length; i--, j++){
            if(chars[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

