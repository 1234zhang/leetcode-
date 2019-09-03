/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (31.01%)
 * Likes:    1315
 * Dislikes: 445
 * Total Accepted:    259.8K
 * Total Submissions: 831.7K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */

import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0){
            return result;
        }
       int r1 = 0, r2 = matrix.length - 1;
       int c1 = 0, c2 = matrix[0].length - 1;
       while(r1 <= r2 && c1 <= c2){
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                result.add(matrix[i][c2]);
            }
            if(r1 < r2 && c1 < c2){
                for (int i = c2 - 1; i > c1; i--) {
                    result.add(matrix[r2][i]);
                }
                for (int i = r2 ; i > r1; i--) {
                    result.add(matrix[i][c1]);
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

