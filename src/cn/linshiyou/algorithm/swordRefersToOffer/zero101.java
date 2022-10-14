package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 101. 分割等和子集
 *
 * https://leetcode.cn/problems/NUPfPr/
 * B站题解：https://www.bilibili.com/video/BV1oZ4y1G7QY/?spm_id_from=333.337.search-card.all.click&vd_source=0e6314eb8042fbe7cef1c990a4e30937
 *
 * 有点思路，写出来不对，看答案
 * 动态规划：类似0-1背包问题
 * 非常棒的一个题目
 */
public class zero101 {

    public static void main(String[] args) {

        int[] nums = {2,2,3,5};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }

    static class Solution {
        public boolean canPartition(int[] nums) {

            int sum = Arrays.stream(nums).sum();
            int max = Arrays.stream(nums).max().getAsInt();
            if (nums.length<2 || sum%2!=0 || max>(sum/2)) return false;

            int n = nums.length;
            int target = sum/2;
            // dp[i][j]：i表示前0~i个数, j表示当前i可能得到的和
            // 如果dp[i][j]==true，表示前0~i中某些数组合起来可以得到j
            boolean[][] dp = new boolean[n][target+1];

            //只考虑当前第一个数，那么可能得到的结果就是nums[0],
            if(nums[0]<=target) dp[0][nums[0]] = true;

            //第一个数已经使用了，接下来从第二个数开始填表
            for (int i=1; i<n; i++){
                for (int j=0; j<=target; j++){
                    //假如不考虑当前的元素则0~i-1可能的情况
                    dp[i][j] = dp[i-1][j];


                    //假如考虑当前的数
                    //  如果当前nums[i]刚好等于j
                    if (nums[i]==j){
                        dp[i][j] = true;
                        continue;
                    }

                    //  计算是否有等于当前j的数，如果有就是true，
                    if (nums[i]<j){
                        dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
                    }

                }
            }
            return dp[n-1][target];
        }
    }

}
