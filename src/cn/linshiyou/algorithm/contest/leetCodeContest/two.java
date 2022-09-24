package cn.linshiyou.algorithm.contest.leetCodeContest;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 2. 交通枢纽
 *
 * https://leetcode.cn/contest/season/2022-fall/problems/D9PW8w/
 * 中等：
 */
public class two {

    public static void main(String[] args) {

        int[][] path = {
//                {0,1},{0,3},{1,3},{2,0},{2,3}
//                {0,3},{1,0},{1,3},{2,0},{3,0},{3,2}
                {2,5},{4,3},{2,3}
        };

        Solution solution = new Solution();
        System.out.println(solution.transportationHub(path));

    }

    static class Solution {
        public int transportationHub(int[][] path) {

            int n = path.length;
            Map<Integer,Set<Integer>> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i=0; i<n; i++){
                int k = path[i][0];
                int value = path[i][1];
                Set<Integer> mapSet = map.getOrDefault(k, new HashSet<>());
                mapSet.add(value);
                map.put(k, mapSet);
                // 所有的结点
                set.add(path[i][0]);
                set.add(path[i][1]);
            }

            for (int one : set){
                if (!map.containsKey(one)){
                    for (int k : set){
                        if (k==one) continue;
                        if (!map.containsKey(k) || !map.get(k).contains(one)) return -1;
                    }
                    return one;
                }
            }
            return -1;
        }
    }


}
