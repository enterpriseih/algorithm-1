package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 091. 粉刷房子
 * 想法：动态规划，依次记录每选择的一个需要花费的最小钱
 *
 * 中等：
 */
public class zero91 {

    public static void main(String[] args) {

        int[][] costs = {
            {17,2,17},
            {16,16,5},
            {14,3,19}
        };

        Solution solution = new Solution();
        System.out.println(solution.minCost(costs));

    }

    static class Solution {
        public int minCost(int[][] costs) {

            int n = costs.length;

            for (int i=1; i<n; i++){
                costs[i][0] = Math.min(costs[i-1][1]+costs[i][0], costs[i-1][2]+costs[i][0]);
                costs[i][1] = Math.min(costs[i-1][0]+costs[i][1], costs[i-1][2]+costs[i][1]);
                costs[i][2] = Math.min(costs[i-1][1]+costs[i][2], costs[i-1][0]+costs[i][2]);
            }

            int min = Math.min(costs[n-1][0], costs[n-1][1]);
            min = Math.min(min, costs[n-1][2]);
            return min;
        }
    }

}
