package cn.linshiyou.algorithm.leetcode;

/**
 * @Author: LJ
 * @Description: 1094. 拼车
 *
 * 法一：差分数组
 *
 */
public class L1094 {


    public static void main(String[] args) {

        int[][] trips = {
            {2,1,5},
            {3,3,7}
        };
        int capacity = 4;

        boolean b = new Solution().carPooling(trips, capacity);
        System.out.println(b);

    }

    /**
     * 差分数组
     */
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {

            // 最多0~1000 一共1001个车站
            int[] diff = new int[1001];

            for (int[] trip : trips){
                // 乘客数量
                int val = trip[0];
                // 乘客上车
                int i = trip[1];
                //乘客在trip[2]下车，及时trip[2]的时候改乘客已经不在车上，
                // 乘客坐车的区间为[trip[1], trip[2]-1]
                int j = trip[2]-1;

                diff[i] += val;
                if (j+1< trips.length){
                    diff[j+1] -= val;
                }

            }

            // 客车不能出现超载的情况

            if (diff[0] > capacity) return false;

            for (int i=1; i<diff.length; i++){
                diff[i] = diff[i-1] + diff[i];
                if (diff[i] > capacity) return false;
            }
            return true;
        }
    }

}
