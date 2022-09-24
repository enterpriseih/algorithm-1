package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 093. 最长斐波那契数列
 *
 * 中等：动态规划
 */
public class zero93 {


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};
//        int[] arr = {1,2,5};
        Solution solution = new Solution();
        System.out.println(solution.lenLongestFibSubseq(arr));

    }

    static class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            Map<Integer, Integer> indices = new HashMap<>();
            int n = arr.length;
            for (int i=0; i<n; i++){
                indices.put(arr[i], i);
            }
            int[][] dp = new int[n][n];
            int ans = 0;
            // arr[k] < arr[j] < arr[i]
            for (int i=0; i<n; i++){
                for (int j=i-1; j>=0 && arr[j]*2 > arr[i]; j--){
                    int k = indices.getOrDefault(arr[i]-arr[j], -1);
                    // 如果k!=-1则 表示找到了一个满足要arr[k] < arr[j] < arr[i]的K，所以长度至少是3
                    if (k>=0){
                        // 以arr[j]，arr[i]，作为数字的末尾 = 以 arr[k]，arr[j]最为数字的末尾+1
                        dp[j][i] = Math.max(dp[k][j]+1, 3);
                    }
                    ans = Math.max(ans, dp[j][i]);
                }
            }
            return ans;

        }
    }

}
