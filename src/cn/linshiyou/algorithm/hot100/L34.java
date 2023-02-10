package cn.linshiyou.algorithm.hot100;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author LJ
 * @create 2023/2/10
 */
public class L34 {

    public static void main(String[] args) {

    }


    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false)-1;
            if (leftIdx<= rightIdx && rightIdx<nums.length && nums[leftIdx]==target && nums[rightIdx]==target){
                return new int[]{leftIdx, rightIdx};
            }

            return new int[]{-1, -1};

        }

        /**
         *
         * @param nums
         * @param target
         * @param lower 低位？高位？
         * @return
         */
        private int binarySearch(int[] nums, int target, boolean lower) {

            int left = 0, right = nums.length-1, ans = nums.length;

            while (left<=right){
                int mid = left + (right-left)/2;

                if (nums[mid] > target || (lower && nums[mid]>=target)){
                    right = mid-1;
                    ans = mid;
                }else {
                    left = mid+1;
                }
            }
            return ans;
        }

    }

}
