package cn.linshiyou.algorithm.hot100;

/**
 * @author LJ
 * @create 2023/4/29
 */
public class L136 {

    public static void main(String[] args) {

    }

    class Solution {
        public int singleNumber(int[] nums) {

            int ans = nums[0];

            for (int i=1; i<nums.length; i++){
                ans ^= nums[i];
            }

            return ans;
        }
    }
}
