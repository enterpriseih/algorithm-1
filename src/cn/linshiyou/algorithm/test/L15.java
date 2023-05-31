package cn.linshiyou.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author shiyou.lin
 * @date 2023/5/8
 */
public class L15 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                -1, -1, 0, 1
        };

        new Solution().threeSum(nums);

    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            int n = nums.length;

            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
// -1 -1 0 1
            for (int l=0;l<n; l++){
                int l2=l+1;
                if (l2<n && nums[l]==nums[l2]) continue;
                if (l2+1<n-1 && nums[l]==nums[l2] && nums[l]==nums[l2+1] ) continue;
                int r=nums.length-1;
                while (l2<r){
                    int cur = nums[l] + nums[l2] + nums[r];
                    if (cur>0){
                        r--;
                    }else if (cur<0){
                        l2++;
                    }else {
                        ans.add(Arrays.asList(nums[l], nums[l2], nums[r]));
                        while (l2<r && nums[l2]==nums[++l2]);
                        while (l2<r && nums[r]==nums[--r]);
                    }
                }
            }
            return ans;
        }
    }

}
