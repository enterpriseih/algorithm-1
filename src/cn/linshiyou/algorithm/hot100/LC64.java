package cn.linshiyou.algorithm.hot100;

import java.util.Arrays;

/**
 * @author LJ
 * @create 2023/4/18
 */
public class LC64 {

    public static void main(String[] args) {

        int[][] grid = {
                {1,2},
                {1,1}
        };

        int i = new Solution().minPathSum(grid);

    }


    static class Solution {
        public int minPathSum(int[][] grid) {

            int n = grid.length;
            int m = grid[0].length;

            int[][] dp = new int[n+1][m+1];
            Arrays.fill(dp[0], Integer.MAX_VALUE);
            for (int i=0; i<=n; i++){
                dp[i][0] = Integer.MAX_VALUE;
            }
/*
1 2
1 1
 */
            for (int i=1; i<=n; i++){

                for (int j=1; j<=m; j++){
                    if (i==1 && j==1){
                        dp[i][j] = grid[i-1][j-1];
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
                }
            }

            return dp[n][m];
        }
    }

}
