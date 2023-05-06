package cn.linshiyou.algorithm.hot100;

import java.util.Arrays;



/**
 * 221. 最大正方形
 *
 * @author shiyou.lin
 * @date 2023/5/6
 */
public class L221 {

    public static void main(String[] args) {

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
//        char[][] matrix = {
//                {'0','1'},
//        };

        new Solution().maximalSquare(matrix);

    }

    static class Solution {

        public int maximalSquare(char[][] matrix) {


            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n+1][m+1];
            int maxAre = 0;

            for (int i=1; i<=n; i++){
                for (int j=1; j<=m; j++){
                    if (matrix[i-1][j-1]=='1'){

                        int tmpMin = Math.min(dp[i-1][j], dp[i][j-1]) ;
                        dp[i][j] = Math.min(tmpMin, dp[i-1][j-1]) + 1;
                        maxAre = Math.max(maxAre, dp[i][j]);
                    }
                }
            }

            return maxAre*maxAre;
        }

    }

}
