package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 105. 岛屿的最大面积
 *
 * 中等：dfs，将已经遍历过的结点标记为0，防止重复遍历
 */
public class zero105 {

    public static void main(String[] args) {
//        int[][] grid = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0},
//        };
        int[][] grid = {
                {0,1},
                {1,1},
        };
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(grid));

    }

    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int area = 0;
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){

                    if (grid[i][j]==0) continue;
                    area = Math.max(area, dfs(grid, i, j));

                }
            }
            return area;
        }

        private int dfs(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if (i<0 || j<0 || i==m || j==n || grid[i][j]==0) return 0;

            int sum = grid[i][j];
            grid[i][j] = 0;//防止重复路径
            sum += dfs(grid, i-1, j);
            sum += dfs(grid, i, j+1);
            sum += dfs(grid, i, j-1);
            sum += dfs(grid, i+1, j);

            return sum;
        }
    }

}
