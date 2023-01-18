package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: LJ
 * @Description: 167. 两数之和 II - 输入有序数组
 *
 * 二分查找
 */
public class L167 {


    public static void main(String[] args) {


        int[] nums = {
            2,7,11,15
        };
        int target = 22;

        int[] solution = new Solution().twoSum(nums, target);

        System.out.println(Arrays.toString(solution));

    }

    /**
     * 类似二分查找，更优质的做法
     */
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int right = numbers.length-1;
            int left = 0;
            while (left<right){
                if (numbers[left]+numbers[right]>target){
                    right--;
                }else if (numbers[left]+numbers[right]==target){
                    return new int[]{left+1, right+1};
                }else {
                    left++;
                }

            }

            return new int[]{-1,-1};
        }
    }


/*
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {

            for (int i=0; i<numbers.length; i++){

                int tmp = target - numbers[i];
                int key = binSerach(numbers, i+1, tmp);
                if (key!=-1){
                    return new int[]{i+1, key+1};
                }
            }

            return new int[]{-1,-1};
        }

        private int binSerach(int[] numbers, int left, int tmp) {
            int right = numbers.length;

            while (left<right){
                int mid = left + ((right-left)>>>1);
                if (numbers[mid]<tmp){
                    left++;
                }else if (numbers[mid]==tmp){
                    return mid;
                }else {
                    right--;
                }
            }
            return -1;
        }
    }
*/

}
