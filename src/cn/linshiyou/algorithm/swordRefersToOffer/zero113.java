package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 113. 课程顺序
 *
 * 解法： 拓扑排序问题
 */
public class zero113 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0}
        };
        int[] order = new Solution().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    static class Solution {
        // 存储有向图
        List<List<Integer>> edges;
        // 标记每个节点的状态：0未搜索，1=搜索中，2=已完成
        int[] visited;
        // 用数组来模拟栈，下标n-1为栈底，0为栈顶
        int[] result;
        // 判断有向图中是否有环
        boolean valid = true;
        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {

            edges = new ArrayList<List<Integer>>();
            for (int i=0; i<numCourses; i++){
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            index = numCourses-1;
            for (int[] info: prerequisites){
                edges.get(info[1]).add(info[0]);
            }
            // 每次挑选一个[未搜索]的节点，开始进行深度优先搜索
            for (int i=0; i<numCourses && valid; i++){
                if (visited[i]==0){
                    dfs(i);
                }
            }

            if (!valid){
                return new int[0];
            }
            // 如果没有环，那么就有拓扑排序
            return result;

        }

        private void dfs(int u) {
            // 将结点标记为[搜索中]
            visited[u] = 1;
            // 搜索其相邻结点
            // 只要发现有环，立刻停止搜索
            for (int v : edges.get(u)){
                // 如果 [未搜索]
                if (visited[v]==0){
                    dfs(v);
                    if (!valid) return;
                }
                // 如果[搜索中]说明找到了环
                else if (visited[v]==1){
                    valid = false;
                    return;
                }
            }
            // 将结点标记为[已完成]
            visited[u] = 2;
            // 将结点入栈
            result[index--] = u;
        }
    }
}
