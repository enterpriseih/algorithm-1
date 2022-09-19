package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 088. 爬楼梯的最少成本
 * 不会
 * 简单：动态规划
 */
public class zero88 {

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));

    }

    static class Solution {
        public int minCostClimbingStairs(int[] cost) {

            int n = cost.length;
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 0;
            for (int i=2; i<=n; i++){
                dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
            }
            return dp[n];
        }
    }

}
