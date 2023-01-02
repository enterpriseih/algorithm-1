package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 115. 重建序列
 *
 * 拓扑排序：bfs
 *
 */
public class zero115 {

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        int[][] sequences = {
                {1,2},
                {1,3},
        };

        boolean s = new Solution().sequenceReconstruction(nums, sequences);
        System.out.println(s);
    }

    static class Solution {
        List<Set<Integer>> edge;
        int[] indegree;


        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            edge = new ArrayList<>();
            int n = nums.length;
            for (int i=0; i<=n; i++)
                edge.add(new HashSet<>());

            indegree = new int[n+1];

            for (int[] sequence : sequences){
                int size = sequence.length;
                for (int i=0; i<size-1; i++){
                    int cur = sequence[i];
                    int next = sequence[i+1];
                    if (edge.get(cur).add(next))
                        indegree[next]++;
                }
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i=1; i<=n; i++){
                if (indegree[i]==0)
                    queue.offer(i);
            }

            while (!queue.isEmpty()){
                if (queue.size()>1) return false;

                int cur = queue.poll();

                Set<Integer> set = edge.get(cur);

                for (int next : set){
                    indegree[next]--;
                    if (indegree[next]==0) queue.offer(next);
                }
            }
            return true;
        }
    }
}
