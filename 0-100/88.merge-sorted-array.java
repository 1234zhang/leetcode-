/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

import java.io.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        while(true){
            if(i < 0 || j < 0){
                break;
            }
            if(nums1[i] >= nums2[j]){
                nums1[i + j + 1] = nums1[i]; 
                i--;
            }else{
                nums1[i + j +1] = nums2[j];
                j--;
            }
            if(i < 0 || j < 0){
                break;
            }
        }
        if(i < 0){
            for (; j >= 0; j--) {
                nums1[j] = nums2[j];   
            }
        }
    }
}


    