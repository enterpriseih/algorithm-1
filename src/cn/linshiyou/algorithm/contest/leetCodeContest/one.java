package cn.linshiyou.algorithm.contest.leetCodeContest;

/**
 * @Author: LJ
 * @Description: 1. 气温变化趋势
 * LeetCode'22力扣杯秋季编程大赛 题目
 * https://leetcode.cn/contest/season/2022-fall/problems/6CE719/
 *
 */
public class one {

    public static void main(String[] args) {

        int[] temperatureA = {21,18,18,18,31};
        int[] temperatureB = {34,32,16,16,17};
        Solution solution = new Solution();
        System.out.println(solution.temperatureTrend(temperatureA, temperatureB));

    }

    static class Solution {
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
            int n = temperatureA.length;
            int[] a = new int[n-1];
            int[] b = new int[n-1];

            for (int i=0; i<n-1; i++){
                if (temperatureA[i+1]-temperatureA[i]==0){
                    a[i] = 0;
                }else if (temperatureA[i+1]-temperatureA[i]>0) {
                    a[i] = 1;
                }else {
                    a[i] = -1;
                }
                if (temperatureB[i+1]-temperatureB[i]==0){
                    b[i] = 0;
                }else if (temperatureB[i+1]-temperatureB[i]>0) {
                    b[i] = 1;
                }else {
                    b[i] = -1;
                }
            }

            int max = 0;
            int temp = 0;
            for (int i=0; i<n-1; i++){
                if (a[i]==b[i]){
                    temp++;
                }else {
                    temp=0;
                }
                max = Math.max(temp, max);
            }
            return max;
        }
    }
}
