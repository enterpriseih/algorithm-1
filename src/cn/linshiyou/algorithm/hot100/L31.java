package cn.linshiyou.algorithm.hot100;

import java.util.Collections;
import java.util.Map;

/**
 * 31. 下一个排列
 *
 * @author LJ
 * @create 2023/2/7
 */
public class L31 {

    public static void main(String[] args) {

    }


    class Solution {
        public void nextPermutation(int[] nums) {
            //倒数第二个数
            int i = nums.length-1-1;

            //从右往左找到一个尽量靠右的较小的数字
            while (i>=0 && nums[i] >= nums[i+1]){
                i--;
            }

            //  //从右往左找到一个较小的大于num[i]的数字
            if(i>=0){
                int j = nums.length-1;
                while (j>=0 && nums[i]>=nums[j]){
                    j--;
                }
                swap(nums, i, j);
            }

            reverse(nums, i+1);


        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
}
