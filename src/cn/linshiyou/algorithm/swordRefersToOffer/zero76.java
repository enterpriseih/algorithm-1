package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 076. 数组中的第 k 大的数字
 *
 * 中等: 调用库函数
 */
public class zero76 {

    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));

    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);

            return nums[nums.length-k];
        }
    }

}
