package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 084. 含有重复元素集合的全排列
 */
public class zero84 {

    public static void main(String[] args) {

        int[] nums = {1,1,2};
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(nums));

    }

    static class Solution {

        private List<List<Integer>> ans;
        private List<Integer> cur;
        private boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {

            ans = new ArrayList<>();
            cur = new ArrayList<>();
            vis = new boolean[nums.length];

            Arrays.sort(nums);

            dfs(nums, 0);

            return ans;
        }

        private void dfs(int[] nums, int index) {

            if (nums.length == index){
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i=0; i<nums.length; i++){


                // 保证在填第index个数的时候重复数字只会被填入一次即可
                if (vis[i] || (i>0 && nums[i]==nums[i-1] && !vis[i-1])){
                    continue;
                }
                cur.add(nums[i]);
                vis[i] = true;
                dfs(nums, index+1);
                vis[i] = false;
                cur.remove(index);
            }

        }
    }

}
