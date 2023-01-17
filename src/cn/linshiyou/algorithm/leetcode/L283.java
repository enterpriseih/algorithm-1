package cn.linshiyou.algorithm.leetcode;


/**
 * @Author: LJ
 * @Description: 283. 移动零
 *
 * 双指针，快慢指针
 */
public class L283 {


    public static void main(String[] args) {


        int[] nums = {
           3,2,2,3
        };

        new Solution().moveZeroes(nums);


    }

    static class Solution {
        public void moveZeroes(int[] nums) {

            int slow = 0;
            int fast = 0;

            // 将结果不为0的值移到前面来
            while (fast!= nums.length){
                if (nums[fast]!=0){
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            // 后面所有值赋为0；
            while (slow!= nums.length){
                nums[slow]=0;
                slow++;
            }

        }
    }

}
