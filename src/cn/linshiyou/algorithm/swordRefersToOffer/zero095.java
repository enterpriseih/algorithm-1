package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 095. 最长公共子序列
 *
 * 中等：动态规划的问题，要做好状态方程的转移问题
 */
public class zero095 {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "abc";
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence(text1, text2));

    }


    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

             int m = text1.length();
             int n = text2.length();
             // 其中dp[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列的长度。
             int[][] dp = new int[m+1][n+1];

             for (int i=1; i<=m; i++){
                 char c1 = text1.charAt(i-1);
                 for (int j=1; j<=n; j++){
                     char c2 = text2.charAt(j-1);
                     if (c1==c2){
                         dp[i][j] = dp[i-1][j-1]+1;
                     }else {
                         dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                     }
                 }
             }

             return dp[m][n];
        }
    }

}
