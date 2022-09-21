package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 090. 环形房屋偷盗
 * 想法：动态规划，与089有相似的地方，只是这里首尾相连，不会。
 * 看了解法之后：我靠难顶，居然这都没想到
 * 中等：动态规划
 */
public class zero90 {

    public static void main(String[] args) {

        int[] nums = {1,3,1,3,100};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));

    }

    static class Solution {
        public int rob(int[] nums) {

            if (nums.length==1) return nums[0];
            if (nums.length==2) return Math.max(nums[0], nums[1]);

            int n = nums.length;

            //如果要偷第一间房，就不偷最后一间
            int one = robRange(nums, 0, n-1);
            //如果不偷第一间，就偷最后一间
            int two = robRange(nums, 1, n);

            return Math.max(one, two);
        }

        private int robRange(int[] nums, int start, int end) {

            int first = nums[start]; //i-2
            int second = Math.max(nums[start], nums[start+1]);//i-1

            for (int i=start+2; i<end; i++){

                int temp = second;
                second = Math.max(first+nums[i], second);
                first = temp;
            }
            return second;
        }
    }

}
