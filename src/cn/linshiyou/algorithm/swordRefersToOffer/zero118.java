package cn.linshiyou.algorithm.swordRefersToOffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 118. 多余的边
 *
 * 理解题意：并查集问题
 *
 * 一棵树边的数量至比结点数少1，
 *
 */
public class zero118 {

    public static void main(String[] args) {

//[[1,2],[2,3],[1,5],[3,4],[1,4]]
        int[][] edges = {
                {1,2},
                {2,3},
                {1,5},
                {3,4},
                {1,4},
        };

        int[] circleNum = new Solution().findRedundantConnection(edges);
        System.out.println(Arrays.toString(circleNum));
    }

    static class Solution {

        public int[] findRedundantConnection(int[][] edges) {

            int n = edges.length;
            int[] parent = new int[n+1];

            for (int i=0; i<=n; i++){
                parent[i] = i;
            }

            for (int[] edge : edges) {
                int f1 = find(parent, edge[0]);
                int f2 = find(parent, edge[1]);

                if (f1 == f2) return edge;

                parent[f1] = f2;
            }
            return new int[2];

        }

        private int find(int[] parent, int index) {
            if (parent[index] != index){
                parent[index] = find(parent, parent[index]);
            }
            return parent[index];
        }
    }

}
