package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 089. 房屋偷盗
 * 想法：动态规划
 * 中等：动态规划, 当前为k,如果要偷k,那么当前金额是nums[k]+nums[k-2], 否则为nums[k-1];
 */
public class zero89 {

    public static void main(String[] args) {

        int[] nums = {2,1,1,2};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));

    }

    static class Solution {
        public int rob(int[] nums) {

            if (nums.length==1) return nums[0];

            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i=2; i<n; i++){
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }

            return dp[n-1];

        }
    }

}
