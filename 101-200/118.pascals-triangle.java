/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        res.add(new ArrayList<Integer>());
        res.get(0).add(1);
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> proRow = res.get(rowNum - 1);
            row.add(1);
            for(int j = 1; j < rowNum; j++){
                row.add(proRow.get(j) + proRow.get(j - 1));
            }

            
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
/**
 * 杨辉三角形，该位的值等于肩上两个的和，首尾始终为1
 */
