package cn.linshiyou.algorithm.hot100;

/**
 * 62. 不同路径
 *
 * @author LJ
 * @create 2023/4/16
 */
public class L62 {
    public static void main(String[] args) {

    }

    class Solution {
        public int uniquePaths(int m, int n) {
            // 表示从起点到达位置 (i, j) 的不同路径数量。
            int[][] dp = new int[m][n];
            //将第一行和第一列的所有元素都设为 1，因为机器人只能向右或向下移动。
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }

            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }

            for (int i=1; i<m; i++){
                for (int j=1; j<n; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[m-1][n-1];
        }
    }

}
