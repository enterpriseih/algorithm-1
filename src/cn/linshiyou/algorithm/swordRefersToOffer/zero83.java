package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 083. 没有重复元素集合的全排列
 *
 *
 * 中等：回溯
 */
public class zero83 {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.permute(nums));

    }

    static class Solution {

        private List<List<Integer>> ans;
        private List<Integer> cur;

        public List<List<Integer>> permute(int[] nums) {

            ans = new ArrayList<>();
            cur = new ArrayList<>();

            for (int num : nums){
                cur.add(num);
            }
            int n = nums.length;
            dfs(n,0);

            return ans;
        }

        public void dfs(int n,int index) {

            // 所有的数都用完了
            if (index==n){
                ans.add(new ArrayList<>(cur));
            }

            for (int i=index; i<n; i++){

                // 动态维护数组，index左侧为已经用过的数，右侧为尚未使用的数
                Collections.swap(cur, index, i);
                // 继续递归下一个数
                dfs(n, index+1);
                Collections.swap(cur, index, i);
            }

        }
    }

}
