package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 102. 加减的目标值
 *
 * 中等：不会
 * 递归回溯
 * 动态规划: 与101类似，注意多体会
 */
public class zero102 {

    public static void main(String[] args) {

    }

    /**
     * 动态规划, 需要先知道
     * neg为符号为-的整数之和的绝对值。
     * sum-neg = 符号为+的整数之后
     * (sum−neg)−neg=sum−2⋅neg=target
     */
    class Solution {

        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();

            int diff = sum - target;
            if (diff<0|| diff%2!=0) return 0;

            int n = nums.length;
            int neg = diff/2;
            int[][] dp = new int[n+1][neg+1];

            //当没有任何元素可以选取时，元素和只能是 00，对应的方案数是 11
            dp[0][0] = 1;

            for (int i=1; i<=n; i++){
                int num = nums[i-1];
                for (int j=0; j<=neg; j++){
                    dp[i][j] = dp[i-1][j];
                    if (j>=num){
                        dp[i][j] += dp[i-1][j-num];
                    }
                }
            }
            return dp[n][neg];

        }
    }

    /**
     * 耗时较多的，回溯法
        class Solution {
            int count = 0;
            public int findTargetSumWays(int[] nums, int target) {
                int sum = Arrays.stream(nums).sum();
                if (sum < target) return 0;

                backtrack(nums, target, 0, 0);
                return count;
            }

            private void backtrack(int[] nums, int target, int index, int sum) {

                if (index == nums.length){
                    if (sum==target) count++;
                }else {
                    backtrack(nums, target, index+1, sum+nums[index]);
                    backtrack(nums, target, index+1, sum-nums[index]);
                }


            }
        }
     */


}
