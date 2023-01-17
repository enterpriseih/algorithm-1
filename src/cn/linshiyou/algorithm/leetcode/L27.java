package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: LJ
 * @Description: 27. 移除元素
 *
 * 双指针
 */
public class L27 {


    public static void main(String[] args) {


        int[] nums = {
           3,2,2,3
        };
        int target = 3;

        int solution = new Solution().removeElement(nums, target);

        System.out.println(solution);

    }

    static class Solution {
        public int removeElement(int[] nums, int val) {

            int slow = 0;
            int fast = 0;
            while (fast!= nums.length){
                if (nums[fast]!=val){
                    nums[slow] = nums[fast];
                    slow++;
                }

                fast++;
            }

            return slow+1;
        }
    }

}
