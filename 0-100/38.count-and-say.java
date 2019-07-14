/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */
class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n - 1);
        str = str + "*";//用于判断是否到结尾；
        char[] chars = str.toCharArray();
        String result = "";
        int count = 1;
        for (int i = 0; i < chars.length; i++){
            if(chars[i] != '*'){
            if(chars[i] == chars[i+1]){
                 count++;
            }else{
                result = result + count + chars[i];
                count = 1;
            }
        }
        }
        return result;
    }
}

