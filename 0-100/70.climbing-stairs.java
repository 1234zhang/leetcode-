/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */
class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        int result = getSteps(steps, n - 1);
        return result;
    }
    public int getSteps(int[] steps, int n){
        if(steps[n] == 0){
            steps[n] = getSteps(steps,n-1) + getSteps(steps,n-2);
        }
        return steps[n];
    }
}

