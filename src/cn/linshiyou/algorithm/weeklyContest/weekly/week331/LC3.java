package cn.linshiyou.algorithm.weeklyContest.weekly.week331;

import java.util.*;

/**
 * @author LJ
 * @create 2023/2/5
 * 不会
 */
public class LC3 {

    public static void main(String[] args) {

    }

    class Solution {
        public int minCapability(int[] nums, int k) {

            int n = nums.length;

            Map<Integer, Integer> map = new HashMap<>();
            for (int i=0; i< nums.length; i++){
                map.put(nums[i], i);
            }
            Arrays.sort(nums);

            int index = 0;
            int max = nums[0];

            List<Integer> list = new ArrayList<>();

            for (int i=1; i<k; i++){

            }


            return max;
        }
    }

}
