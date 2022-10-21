package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.LinkedList;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 107. 矩阵中的距离
 *
 * 从0开始广度优先遍历。取最小值
 */
public class zero107 {

    public static void main(String[] args) {

        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.updateMatrix(mat));

    }
    static class Solution {

        int[][] dirs = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1},
        };

        public int[][] updateMatrix(int[][] mat) {

            int m = mat.length;
            int n = mat[0].length;
            int[][] dist = new int[m][n];
            boolean[][] seen = new boolean[m][n];
            LinkedList<int[]> queue = new LinkedList<>();

            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    if (mat[i][j]==0){
                        queue.addLast(new int[]{i, j});
                        seen[i][j] = true;
                    }
                }
            }

            //广度优先遍历
            while (!queue.isEmpty()){
                int[] cell = queue.removeFirst();
                int i = cell[0];
                int j = cell[1];
                for (int d=0; d<4; d++){
                    int ni = i + dirs[d][0];
                    int nj = j + dirs[d][1];

                    if (ni>=0 && ni<m && nj>=0 && nj<n && !seen[ni][nj]){
                        dist[ni][nj] = dist[i][j]+1;
                        queue.addLast(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }

                }
            }

            return dist;
        }
    }

}
