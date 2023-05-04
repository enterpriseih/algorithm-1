package cn.linshiyou.algorithm.hot100;

import java.util.Arrays;

/**
 * 200. 岛屿数量
 *
 * @author shiyou.lin
 * @date 2023/5/4
 */
public class L200 {

    public static void main(String[] args) {

    }

    class Solution {
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] flag = new boolean[n+1][m+1];

            for (int i=0; i<n+1; i++){
                Arrays.fill(flag[i], false);
            }
            int ans = 0;

            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if (!flag[i][j] && grid[i][j]=='1'){
                        System.out.printf("flag[%d][%d]:%b",i,j,flag[i][j]);
                        ans++;
                        dfs(grid, flag, i, j);
                    }

                }
            }

            return ans;
        }

        private void dfs(char[][] grid, boolean[][] flag, int row, int col) {
            int n = grid.length;
            int m = grid[0].length;
            if (row>=n || col>=m || row<0 || col<0
                    || flag[row][col] || grid[row][col]=='0') return;

            flag[row][col] = true;
            System.out.printf("flag[%d][%d]:%b \n",row,col,flag[row][col]);
            dfs(grid, flag, row+1, col);
            dfs(grid, flag, row-1, col);
            dfs(grid, flag, row, col+1);
            dfs(grid, flag, row, col-1);

        }
    }

}
