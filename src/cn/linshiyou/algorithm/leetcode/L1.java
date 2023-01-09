package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: LJ
 * @Description: 1. 两数之和
 *
 * 栈：
 */
public class L1 {


    public static void main(String[] args) {


        int[] nums = {
           3,3
        };
        int target = 6;

        int[] solution = new Solution().twoSum(nums, target);

        System.out.println(Arrays.toString(solution));

    }
    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i=0; i< nums.length; i++){
                if (map.containsKey(target-nums[i])){
                    return new int[]{map.get(target-nums[i]), i};
                }
                map.put(nums[i], i);
            }


            return new int[0];
        }
    }

}
