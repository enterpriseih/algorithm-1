package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 103. 最少的硬币数目
 *
 * 中等：动态规划
 */
public class zero103 {

    public static void main(String[] args) {


    }


    class Solution {
        public int coinChange(int[] coins, int amount) {

            int max = amount+1;
            int[] dp = new int[max];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i=1; i<max; i++){

                for (int j=0; j<coins.length; j++){
                    if (coins[j]<=i){
                        dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                    }
                }
            }
            return dp[amount] > amount? -1:dp[amount];

        }
    }

}
