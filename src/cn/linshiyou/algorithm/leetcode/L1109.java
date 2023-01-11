package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: LJ
 * @Description: 1109. 航班预订统计
 *
 * 差分数组
 *
 */
public class L1109 {


    public static void main(String[] args) {

        int[][] bookings = {
            {1,2,10},
            {2,3,20},
            {2,5,25}
        };
        int n = 5;

        int[] b = new Solution().corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(b));

    }



    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {


            int[] diff = new int[n+1];
            int[] ans = new int[n];

            for (int i=0; i< bookings.length; i++){

                diff[bookings[i][0]] += bookings[i][2];

                if (bookings[i][1]+1 < diff.length){
                    diff[bookings[i][1]+1] -= bookings[i][2];

                }


            }
            ans[0] = diff[1];
            for (int i=1; i<ans.length; i++){
                ans[i] = ans[i-1] + diff[i+1];
            }

            return ans;
        }
    }
}
