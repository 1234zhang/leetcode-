/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (31.95%)
 * Likes:    2233
 * Dislikes: 113
 * Total Accepted:    332.9K
 * Total Submissions: 1M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    char[][] board;
    // 表示有多少行
    int m;
    // 表示有多少列
    int n;
    boolean[][] marked;
    String word;
    int[][] direction = {
        {-1,0}, {0,1},{1,0},{0,-1}
    };
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        
        m = board.length;
        if(m < 1){
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start){
        if(start == word.length() - 1 && board[i][j] == word.charAt(word.length() - 1)){
            return true;
        }
        if(board[i][j] == word.charAt(start)){
            for (int h = 0; h < direction.length; h++) {
                marked[i][j] = true;
                int newI = i + direction[h][0];
                int newJ = j + direction[h][1];
                if(inArea(newI, newJ) && !marked[newI][newJ]){
                    if(dfs(newI, newJ, start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int i, int j){
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}

