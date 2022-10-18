package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 104. 排列的数目
 *
 * 动态规划：
 */
public class zero104 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(nums, target));
    }


    static class Solution {
        public int combinationSum4(int[] nums, int target) {

            int dp[] = new int[target+1];
            dp[0] = 1;

            //dp[1] = {1}
            //dp[2] = {1,1}, {2},
            //dp[3] = {1,1,1} , {2,1}  + {1,2} + {3}
            //dp[4] = {1,1,1},{2,1,1},{1,2,1},{3,1} + {1,1,2},{2,2}+{1,3}


            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (num <= i) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }

}
