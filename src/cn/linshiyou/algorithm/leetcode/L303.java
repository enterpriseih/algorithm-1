package cn.linshiyou.algorithm.leetcode;

/**
 * @Author: LJ
 * @Description: 303. 区域和检索 - 数组不可变
 *
 * 前缀和技巧
 */
public class L303 {


    public static void main(String[] args) {


        int[] nums = {
                -2, 0, 3, -5, 2, -1
        };
        int left = 0;
        int right = 2;

        NumArray obj = new NumArray(nums);
        int param1 = obj.sumRange(left,right);
        System.out.println(param1);
    }

    static class NumArray {

        int[] preSum;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.preSum = new int[n+1];
            for (int i=1; i<preSum.length; i++){
                this.preSum[i] = this.preSum[i-1]+nums[i-1];
            }

        }

        public int sumRange(int left, int right) {

            return preSum[right+1]- preSum[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

}
