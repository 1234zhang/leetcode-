/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */
import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> trangle = new ArrayList<>();
        trangle.add(new ArrayList<>());
        trangle.get(0).add(1);
        if(rowIndex == 0){
            return trangle.get(0);
        }
        for (int rowNum = 1; rowNum <= rowIndex; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> proRow = trangle.get(rowNum - 1);
            row.add(1);
            for (int i = 1; i < rowNum; i++) {
                row.add(proRow.get(i) + proRow.get(i-1));
            }
            row.add(1);
            trangle.add(row);
        }
        return trangle.get(rowIndex);
    }
}

