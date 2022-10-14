package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 100. 三角形中最小路径之和
 *
 * 动态规划：一种动态规划的思路，
 * 注意临界条件，另外需要将dp中所有数初始化为最大数Integer.MAX_VALUE
 * 转移方程主要是：dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + cur.get(j);
 */
public class zero100 {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(triangle));
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int m = triangle.get(triangle.size()-1).size();

            int[][] dp = new int[n][m];
            for (int i=0; i<n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i=0; i<n; i++){
                List<Integer> cur = triangle.get(i);
                for (int j=0; j<cur.size(); j++){

                    if (i==0) dp[i][j] = cur.get(j);
                    else if (j==0){
                        dp[i][j] = dp[i-1][j] + cur.get(j);
                    }
                    else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + cur.get(j);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i=0; i<m; i++){
                min = Math.min(min, dp[n-1][i]);
            }
            return min;
        }
    }

}
