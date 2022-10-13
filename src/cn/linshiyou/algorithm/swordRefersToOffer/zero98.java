package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 098. 路径的数目
 *
 * dfs：超时
 * 动态规划：完美
 */
public class zero98 {

    public static void main(String[] args) {

        int m = 3;
        int n = 2;
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(m, n));



    }

    /**
     * 动态规划的思路，判断每一格有多少种走法
     * 因为机器人只能向下和向右移动，所以当前格的走法为：左边格的走法+上面一格的走法
     * 即动态规划转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    static class Solution {
        public int uniquePaths(int m, int n) {

            int[][] dp = new int[m][n];
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    if (i==0){
                        dp[i][j] = 1;
                        continue;
                    }
                    if (j==0){
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[m-1][n-1];
        }
    }

    /**
     * 使用回溯的方式会超时
     * m=51, n=9

        static class Solution {

            public int uniquePaths(int m, int n) {

                int i=1, j=1;
                int sum = 0;

                return dfs(i, j, m, n, sum);
            }

            private int dfs(int i, int j, int m, int n, int sum) {

                if (i>m || j>n) return sum;

                if (i==m && j==n){
                    return sum+1;
                }

                if (i+1<=m) sum = dfs(i+1, j, m, n, sum);
                if (j+1<=n) sum = dfs(i, j+1, m, n, sum);

                return sum;
            }
        }
     */
}
