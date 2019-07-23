import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        if(s.length() <= 1){
            return 1;
        }
        Map<Character,Integer> charsMap = new HashMap<>();
        int max = 0;
        int i = 0, j = 0;
        while(i < s.length() && j < s.length()){
            if(!charsMap.containsKey(s.charAt(j))){
                charsMap.put(s.charAt(j),j++);
                max = Math.max(max, j - i);
            }else{
                charsMap.remove(s.charAt(i++));
            }
        }
        return max;
    }
}

/**
 * 使用滑动窗口解决问题。
 * 1.创建一个map作为窗口，map中存放字符以及字符位置
 * 2.建立一个循环，遍历整个字符串。并进行如下步骤
 *   a 判断这个字符是否在窗口中，如果不在，就添加进窗口，将窗口右边界加一。
 *      加一之后，右边界减去左边界，获得窗口大小，即是子串长度。将max更改为当前字串长度与之间max之间的较大值。
 *   b 如果该字符在该窗口中，缩小左边界，直到该字符不在该窗口中。
 *  */