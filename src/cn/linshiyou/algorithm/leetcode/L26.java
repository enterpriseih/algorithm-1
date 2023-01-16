package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: LJ
 * @Description: 26. 删除有序数组中的重复项
 *
 * 栈：
 */
public class L26 {


    public static void main(String[] args) {


        int[] nums = {
               1,2
        };

        int solution = new Solution().removeDuplicates(nums);

        System.out.println(solution);

    }
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length==1) return 1;

            int slow = 0;
            int fast = 0;
            while (fast< nums.length){
                if (nums[fast]!=nums[slow]){
                   slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow+1;
        }
    }

}
