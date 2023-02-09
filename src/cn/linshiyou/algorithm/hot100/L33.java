package cn.linshiyou.algorithm.hot100;

/**
 * 33. 搜索旋转排序数组
 *
 * @author LJ
 * @create 2023/2/8
 */
public class L33 {


    public static void main(String[] args) {

        int[] nums = new int[]{4,5,6,7,0,1,2};

        int target = 0;
        new Solution().search(nums, target);

    }

    static class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;;
            if (n==0) return -1;
            if (n==1) return nums[0]==target? 0:-1;

            int left = 0, right = n-1;
            while (left<=right){
//                int mid = (right-left)>>1 + left;
                int mid = left + (right-left) / 2;
                if (nums[mid] == target) return mid;
                // 左边区域有序
                if (nums[0] <= nums[mid]){
                    if (nums[0]<=target && target < nums[mid]){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }else {
                    //在右边区域
                    if (nums[mid] < target && target <= nums[n-1]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
