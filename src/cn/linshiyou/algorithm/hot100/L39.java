package cn.linshiyou.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author LJ
 * @create 2023/2/11
 */
public class L39 {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();

            dfs(candidates, target, ans, combine, 0);

            return ans;
        }

        private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {

            if (idx == candidates.length) return;
            if (target == 0){
                ans.add(new ArrayList<>(combine));
                return;
            }
            // 直接跳过(这一句也可以放在下面)
            dfs(candidates, target, ans, combine, idx+1);
            // 选择当前数
            if (target - candidates[idx] >= 0){
                combine.add(candidates[idx]);
                dfs(candidates, target-candidates[idx], ans, combine, idx);
                combine.remove(combine.size()-1);
            }

//            放在这也同样适用，前者从后往前，这个是从前往后
//            dfs(candidates, target, ans, combine, idx+1);


        }
    }

}
