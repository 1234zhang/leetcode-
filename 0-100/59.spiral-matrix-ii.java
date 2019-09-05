/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (47.63%)
 * Likes:    537
 * Dislikes: 86
 * Total Accepted:    147K
 * Total Submissions: 305.9K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int[][] result = new int[n][n];
        int element = 1;
        while(r1 <= r2 && c1 <= c2){
            for (int i = c1; i <= c2; i++) {
                result[r1][i] = element++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                result[i][c2] = element++;
            }
            if(r1 < r2 && c1 < c2){
                for (int i = c2 - 1; i >= c1; i--) {
                    result[r2][i] = element++;
                }
                for (int i = r2 - 1; i >= c1 + 1; i--) {
                    result[i][c1] = element++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }
}

