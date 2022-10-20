package cn.linshiyou.algorithm.swordRefersToOffer;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 106. 二分图
 *
 * 二分图：将图分为两个集合，集合内部没有边，边都在集合之间
 * 中等：可以使用染色法;dfs
 */
public class zero106 {

    public static void main(String[] args) {


    }



    class Solution {

        private static final int UNCOLORED = 0;//未染色
        private static final int RED = 1;//红色
        private static final int BLACK = 2;//黑色
        private int[] color;
        private boolean valid;


        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            valid = true;
            color = new int[n];
            Arrays.fill(color, UNCOLORED);
            for (int i=0; i<n; i++){
                //如果未染色，就将该结点染为红色，并一直追溯下一个结点染为不一样的颜色
                if (color[i]==UNCOLORED){
                    dfs(i, RED, graph);
                }
            }

            return valid;
        }
        private void dfs(int node, int c, int[][] graph) {

            color[node] = c;
            int cNei = c==RED? BLACK:RED;

            for (int neighbor: graph[node]){
                if (color[neighbor]==UNCOLORED){
                    dfs(neighbor, cNei, graph);
                    if (!valid){
                        return;
                    }
                }else if (color[neighbor]!= cNei){
                    valid = false;
                    return;
                }
            }
        }
    }




}
