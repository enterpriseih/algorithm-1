package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 079. 所有子集
 * 不会
 * 中等：迭代法实现子集枚举
 *
 */
public class zero79 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        Solution solution = new Solution();
        System.out.println(solution.subsets(nums));
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> t = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();

            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<>(t));
            }
            return ans;

        }
    }
}
