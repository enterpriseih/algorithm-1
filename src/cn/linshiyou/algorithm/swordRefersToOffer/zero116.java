package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 116. 省份数量
 *
 * 理解题意：可以考虑入度为0的即使一个省份
 *
 */
public class zero116 {

    public static void main(String[] args) {


//[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int[][] isConnected = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1},
        };

        int circleNum = new Solution().findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    static class Solution {

        public int findCircleNum(int[][] isConnected) {
            int cities = isConnected.length;
            boolean[] visited = new boolean[cities];
            int provinces = 0;
            for (int i=0; i<cities; i++){
                if (!visited[i]){
                    dfs(isConnected, visited, cities, i);
                    provinces++;
                }
            }

            return provinces;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
            for (int j=0; j<cities; j++){
                if (isConnected[i][j]==1 && !visited[j]){
                    visited[j] = true;
                    dfs(isConnected, visited, cities, j);
                }
            }
        }
    }
}
