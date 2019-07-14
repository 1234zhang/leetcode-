/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */
class Solution {
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == needle.length()){
            return i - j;
        }else{
            return -1;
        }
    }
    public static int[] getNext(String needle){
        int[] next = new int[needle.length()];
        if(needle.length() == 1){
            next[0] = -1;
            return next;
        }
        int k = 0;
        int j = 1;
        next[0] = -1;
        next[1] = 0;
        while(j < needle.length()-1){
            k = next[j];
            if(needle.charAt(k) == needle.charAt(j)){
                next[j+1] = 1 + k;
                j++;
            }else{
                next=getNext(needle,next,j,next[k]);
                j++;
            }
        }
        return next;
    }
    public static int[] getNext(String needle,int[] next,int j, int k){
        if(k == -1){
            next[j+1] = 0;
            return next;
        }else{
            if(needle.charAt(k) == needle.charAt(j)){
                next[j+1] = k+1;
            }else{
                next = getNext(needle,next,j,next[k]);
            }
        }
        return next;
    }
}
/**
 * KMP相关算法：https://blog.csdn.net/v_july_v/article/details/7041827
 */

