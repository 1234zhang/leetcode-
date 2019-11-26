/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (36.28%)
 * Likes:    1798
 * Dislikes: 0
 * Total Accepted:    115.6K
 * Total Submissions: 318.5K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0;
        int iMax = m;
        int half = (m + n + 1) /2;
        while(iMin <= iMax){
            int i = (iMax + iMin) / 2;
            int j = half - i;
            if(i < iMax && nums2[j - 1] > nums1[i]){
                iMin = i + 1;
            }else if(i > iMin && nums1[i - 1] > nums2[j]){
                iMax = i - 1;
            }else{
                int left = 0;
                int right = 0;
                if(i == 0) left = nums2[j - 1];
                else if(j == 0) left = nums1[i - 1];
                else left = Math.max(nums1[i - 1], nums2[j - 1]);
                if((m + n) % 2 != 0) return left;

                if(i == m) right = nums2[j];
                else if(j == n) right = nums1[i];
                else right = Math.min(nums1[i], nums2[j]);
                return (right + left) / 2.0;
            }
        }
        return 0;
    }
}
// @lc code=end

