package cn.linshiyou.algorithm.hot100;

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 *
 * @author LJ
 * @create 2023/4/22
 */
public class L75 {

    public static void main(String[] args) {

    }

    class Solution {
        public void sortColors(int[] nums) {

            int len = nums.length;

            int zero = 0;

            int two = len;
            int i=0;

            while (i< two){
                if (nums[i]==0){
                    swap(nums, i, zero);
                    zero++;
                    i++;
                }else if (nums[i] == 1) {
                    i++;
                }else {
                    two --;
                    swap(nums, i, two);
                }
            }
        }
        public void swap(int[] nums, int i, int j){

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
