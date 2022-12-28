package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 112. 最长递增路径
 *
 * bfs：单纯的暴力dfs不行，必须配合上动态规划，记录下每一个数字可以达到的极限。
 */
public class zero112 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1},
        };
        int x = new Solution().longestIncreasingPath(matrix);
        System.out.println(x);
    }

}

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int temp = dfs(matrix, i, j, 1);
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col, int step) {
        int cur = matrix[row][col];
        int tempMax = step;
        if (isCross(row-1, col, matrix) && cur<matrix[row-1][col]){
            tempMax = dfs(matrix, row-1, col, step+1);
        }
        if (isCross(row+1, col, matrix) && cur<matrix[row+1][col]){
            tempMax = Math.max(tempMax, dfs(matrix, row+1, col, step+1));
        }
        if (isCross(row, col-1, matrix) && cur<matrix[row][col-1]){
            tempMax = Math.max(tempMax, dfs(matrix, row, col-1, step+1));
        }
        if (isCross(row, col+1, matrix) && cur<matrix[row][col+1]){
            tempMax = Math.max(tempMax, dfs(matrix, row, col+1, step+1));
        }
        return tempMax;
    }

    private boolean isCross(int row, int col, int[][] matrix){
        if (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length) return true;
        return false;
    }
}