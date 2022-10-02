package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 097. 子序列的数目
 */
public class zero97 {

    public static void main(String[] args) {

        String s = "rabbbit", t = "rabbit";

        Solution solution = new Solution();
        System.out.println(solution.numDistinct(s, t));


    }

    static class Solution {
        public int numDistinct(String s, String t) {

            int m = s.length(), n = t.length();
            if (m<n) return 0;
            // s[i:]:表示下标从i到末尾
            //其中 dp[i][j]表示在 s[i:]的子序列中 t[j:]出现的个数。
            int[][] dp = new int[m + 1][n + 1];

            // j==n是，t[j:]为空字符串，因此对于任意的0<=i<=m，有dp[i][n]=1;
            for (int i=0; i<=m; i++) dp[i][n] = 1;
            //当 i=m 且 j<n 时，s[i:] 为空字符串，t[j:] 为非空字符串，由于非空字符串不是空字符串的子序列，因此对任意 0≤j<n，有dp[m][j]=0。

            for (int i = m - 1; i >= 0; i--) {
                char sChar = s.charAt(i);
                for (int j = n - 1; j >= 0; j--) {
                    char tChar = t.charAt(j);
                    if (sChar == tChar) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];

        }
    }

}
