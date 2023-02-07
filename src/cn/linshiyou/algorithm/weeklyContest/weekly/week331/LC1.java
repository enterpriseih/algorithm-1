package cn.linshiyou.algorithm.weeklyContest.weekly.week331;

import java.util.Arrays;

/**
 * @author LJ
 * @create 2023/2/5
 */
public class LC1 {

    public static void main(String[] args) {

    }


    class Solution {
        public long pickGifts(int[] gifts, int k) {

            int n = gifts.length;
            long ans = 0;
            for (int i=0; i<k; i++){
                Arrays.sort(gifts);
                int x = gifts[n-1];
                int sqrt = (int) Math.sqrt(x);
                gifts[n-1] = sqrt;

            }

            for (int i=0; i<n; i++){
                ans += gifts[i];
            }


            return ans;
        }
    }
}
