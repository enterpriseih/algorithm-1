package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 082. 含有重复元素集合的组合
 * @url: https://leetcode.cn/problems/4sjJUc/
 * 难点：每个组合只能出现一次
 * 方法与081有相似之处
 * 中等
 */
public class zero82 {

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;

        Solution solution = new Solution();

        System.out.println(solution.combinationSum2(nums, target));
    }

    static class Solution {

        //int[0]:不重复数，int[1]:出现次数
        List<int[]> freq;
        private List<List<Integer>> ans;
        private List<Integer> cur;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            ans = new ArrayList<>();
            cur = new ArrayList<>();
            freq = new ArrayList<>();

            Arrays.sort(candidates);
            for (int num : candidates) {
                int size = freq.size();
                if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                    freq.add(new int[]{num, 1});
                } else {
                    freq.get(size - 1)[1]++;
                }
            }

            dfs(0, target);

            return ans;
        }

        private void dfs(int index, int target) {

            if (target == 0){
                ans.add(new ArrayList<>(cur));
                return;
            }

            if (index==freq.size() || target < freq.get(index)[0]) return;

            // 跳过当前数
            dfs(index+1, target);

            int most = Math.min(target / freq.get(index)[0], freq.get(index)[1]);
            for (int i=1; i<=most; i++){
                cur.add(freq.get(index)[0]);
                dfs(index+1, target-i*freq.get(index)[0]);
            }
            for (int i = 1; i <= most; ++i) {
                cur.remove(cur.size() - 1);
            }
        }
    }

}
