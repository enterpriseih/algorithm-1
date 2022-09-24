package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 092. 翻转字符
 * 想法：
 *
 * 中等：动态规划
 */
public class zero92 {

    public static void main(String[] args) {

        String s = "00100";
        Solution solution = new Solution();
        System.out.println(solution.minFlipsMonoIncr(s));

    }

    static class Solution {
        public int minFlipsMonoIncr(String s) {

            int n = s.length();
            int dp0 = 0, dp1 = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int dp0New = dp0;//dp[i-1]
                int dp1New = Math.min(dp0, dp1);//dp[i]，当前翻转次数最少的操作
                if (c == '1') {
                    // 如果当前为1，翻转为0，翻转为0的次数++
                    dp0New++;
                } else {
                    // 如果当前为0，翻转为1，翻转为1的次数++
                    dp1New++;
                }
                dp0 = dp0New;
                dp1 = dp1New;
            }

            return Math.min(dp0, dp1);
        }
    }


}
