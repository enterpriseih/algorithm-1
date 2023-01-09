package cn.linshiyou.algorithm.swordRefersToOffer;


import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 119. 最长连续序列
 *
 * 排序之后，寻找
 *
 */
public class zero119 {

    public static void main(String[] args) {


        int[] nums = {
                100,4,200,1,3,2
        };

        int res = new Solution().longestConsecutive(nums);
        System.out.println(res);
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (n==0) return 0;

            Arrays.sort(nums);

             int res = 1;
             int cur = nums[0];
             int k = 0;
             for (int i=0; i<n; i++){

                 if (nums[i]==cur+k)
                     continue;
                 if (nums[i] == cur+k+1)
                     k++;
                 else {
                     res = Math.max(k+1, res);
                     cur = nums[i];
                     k=0;
                 }

             }
             return Math.max(k+1, res);

        }
    }

}
