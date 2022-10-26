package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 110. 所有路径
 *
 * 中等：dfs
 */
public class zero110 {

    public static void main(String[] args) {

        int[][] graph = {
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };
        Solution solution = new Solution();
        System.out.println(solution.allPathsSourceTarget(graph));

    }

    /**
     * 非常优秀的写法
     */
    static class Solution {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            stack.offerLast(0);
            dfs(graph, 0, graph.length - 1);
            return ans;
        }

        public void dfs(int[][] graph, int x, int n) {
            if (x == n) {
                ans.add(new ArrayList<Integer>(stack));
                return;
            }
            for (int y : graph[x]) {
                stack.offerLast(y);
                dfs(graph, y, n);
                stack.pollLast();
            }
        }
    }



/**
 * 我的写法

    static class Solution {
        Map<Integer, List<Integer>> map;
        List<List<Integer>> ans;
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            int n = graph.length;
            map = new HashMap<>();
            for (int i=0; i<n; i++){
                List<Integer> list = new ArrayList<>();
                for (int j=0; j<graph[i].length; j++){
                    list.add(graph[i][j]);
                }
                if (list.size()!=0) map.put(i, list);
            }

            ans = new ArrayList<>();
            if (!map.containsKey(0)) return ans;
            List<Integer> startList = map.get(0);
            for (int i=0; i<startList.size(); i++){
                List<Integer> ansOne = new ArrayList<>();
                ansOne.add(0);
                ansOne.add(startList.get(i));
                dfs(startList.get(i), map, ansOne, n);
            }


            return ans;
        }

        private void dfs(int index, Map<Integer, List<Integer>> map, List<Integer> ansOne, int n) {
            if (ansOne.get(ansOne.size()-1)==n-1){
                ans.add(new ArrayList<>(ansOne));
                return;
            }

            if (!map.containsKey(index)) return;

            List<Integer> mapList = map.get(index);
            for (int i=0; i<mapList.size(); i++){
                ansOne.add(mapList.get(i));
                dfs(mapList.get(i), map, ansOne, n);
                ansOne.remove(mapList.get(i));
            }

        }
    }
 */
}
