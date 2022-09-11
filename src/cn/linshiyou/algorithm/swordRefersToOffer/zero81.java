package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 081. 允许重复选择元素的组合
 * 不会：与题80有一点类似的地方，采用搜索回溯
 * 中等
 */
public class zero81 {

    public static void main(String[] args) {

        int[] nums = {2,3,6,7};
        int target = 7;

        Solution solution = new Solution();

        System.out.println(solution.combinationSum(nums, target));

    }

    static class Solution {

        List<List<Integer>> ans;
        List<Integer> cur;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            ans = new ArrayList<>();
            cur = new ArrayList<>();
            dfs(candidates, target,  0);
            return ans;


        }

        /**
         *
         * @param candidates
         * @param target 当前目标值
         * @param index candidates中的索引值
         */
        private void dfs(int[] candidates, int target, int index) {

            if (candidates.length==index) return;

            if (target == 0){
                ans.add(new ArrayList<>(cur));
                return;
            }

            // 直接跳过
            dfs(candidates, target, index+1);

            // 选择当前数
            if (target - candidates[index] >= 0){
                cur.add(candidates[index]);
                dfs(candidates, target - candidates[index], index);
                cur.remove(cur.size()-1);
            }

        }
    }

}
