package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 070. 排序数组中只出现一次的数字
 * 中等：利用位运算的特性
 * 异或^: 相同为0，不同为1
 * 方法：遍历依次异或即可。时间复杂度O(n)
 */
public class zero70 {

    public static void main(String[] args) {

        int[] nums = {1,1,2,3,3,4,4,8,8};
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(nums));

    }

    static class Solution {
        // 暴力方法
        public int singleNonDuplicate(int[] nums) {
            int ans = 0;
            int n = nums.length;

            for (int i=0; i<n; i++){
                ans ^= nums[i];
            }
            return ans;
        }
    }



}
