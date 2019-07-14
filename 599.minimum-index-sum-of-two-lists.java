import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=599 lang=java
 *
 * [599] Minimum Index Sum of Two Lists
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Integer minNum = Integer.MAX_VALUE;
        List<String> res = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if(j != null && i+j <= minNum){
                if(i + j < minNum){
                    res.clear();
                    minNum = i+j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);   
    }
}
/**
 * NOTE:
 * 使用map存储数组的数据以及下标，可以快速的找到相同的字符串。
 * 将时间复杂度从O（m*n）降低到O（m+n)
 */
