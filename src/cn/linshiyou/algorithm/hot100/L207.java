package cn.linshiyou.algorithm.hot100;

import java.util.*;

/**
 * 207. 课程表
 *
 * @author shiyou.lin
 * @date 2023/5/4
 */
public class L207 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0}
        };
        new Solution().canFinish(numCourses, prerequisites);
    }


    static class Solution {

        /**
         * 节点与边的指向信息
         */
        List<List<Integer>> edges;
        /**
         * 点的入度
         */
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length==0 || numCourses==0) return true;

            edges = new ArrayList<>();
            for (int i=0; i<numCourses; i++){
                edges.add(new ArrayList<>());
            }

            indeg = new int[numCourses];
            for (int[] info : prerequisites){
                edges.get(info[1]).add(info[0]);
                indeg[info[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            // 将入度为0的点加入队列中
            for (int i=0; i<numCourses; i++){
                if (indeg[i]==0){
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()){
                visited++;
                int u = queue.poll();
                for (int v: edges.get(u)){
                    indeg[v]--;
                    if (indeg[v]==0){
                        queue.offer(v);
                    }
                }
            }

            return visited==numCourses;
        }
    }

}
