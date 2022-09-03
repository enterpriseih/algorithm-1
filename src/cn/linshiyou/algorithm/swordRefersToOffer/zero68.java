package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 068. 查找插入位置
 * 简单
 * 二分法 ，查找第一个大于等于target的值
 */
public class zero68 {

    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 5;

        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, target));


    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {

            int n = nums.length;

            int left = 0;
            int right = n - 1;
            int res = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }
    }
}
