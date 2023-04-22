package cn.linshiyou.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author LJ
 * @create 2023/4/22
 */
public class L78 {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        new Solution().subsets(nums);
    }


    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());

            List<Integer> temp = new ArrayList<>();
            dfs(0, nums, ans, temp);

            return ans;
        }

        private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
            int n = nums.length;
            if (i>=n){
                return;
            }

            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            dfs(i+1, nums, ans, temp);
            temp.remove(temp.size()-1);

            dfs(i+1, nums, ans, temp);

        }
    }

}
