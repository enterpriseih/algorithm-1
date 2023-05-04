package cn.linshiyou.algorithm.hot100;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/
 *
 * @author shiyou.lin
 * @date 2023/5/4
 */
public class L198 {

    public static void main(String[] args) {

    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n==1) return nums[0];
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0], nums[1]);

            for (int i=2; i<n; i++){
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);

            }

            return dp[n-1];
        }

    }

}
