package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 112. 最长递增路径
 *
 * bfs：单纯的暴力dfs不行，必须配合上记忆
 *
 * 解法：记忆化深度优先搜索（在有向图中寻找最长路径问题）
 */
public class zero112 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        int[][] matrix = {
                {3,4,5},
                {3,2,6},
                {2,2,1},
        };
        int x = new Solution().longestIncreasingPath(matrix);
        System.out.println(x);
    }

    static class Solution {

        int[][] dp = null;

        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            dp =new int[m][n];
            for (int i=0; i<m; i++)
                Arrays.fill(dp[i], 1);


            int max = Integer.MIN_VALUE;
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    max = Math.max(max,  dfs(matrix, i, j));
                }
            }
            return max;
        }

        private int dfs(int[][] matrix, int row, int col) {
            if (dp[row][col]!=1) return dp[row][col];
            int cur = matrix[row][col];

            if (isCross(row-1, col, matrix) && cur < matrix[row-1][col]){
                dp[row][col] = Math.max(dp[row][col], dfs(matrix, row-1, col)+1);
            }

            if (isCross(row+1, col, matrix) && cur < matrix[row+1][col]){
                dp[row][col] = Math.max(dp[row][col], dfs(matrix, row+1, col)+1);
            }

            if (isCross(row, col-1, matrix) && cur < matrix[row][col-1]){
                dp[row][col] = Math.max(dp[row][col], dfs(matrix, row, col-1)+1);
            }

            if (isCross(row, col+1, matrix) && cur < matrix[row][col+1]){
                dp[row][col] = Math.max(dp[row][col], dfs(matrix, row, col+1)+1);
            }


            return dp[row][col];
        }


        private boolean isCross(int row, int col, int[][] matrix){
            if (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length) return true;
            return false;
        }
    }

}
