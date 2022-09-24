package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 094. 最少回文分割
 * 想法: 与题86有相似的地方
 *
 * 困难：
 */
public class zero94 {

    public static void main(String[] args) {
        String s = "google";
        Solution solution = new Solution();
        System.out.println(solution.minCut(s));

    }
    static class Solution {
        public int minCut(String s) {

            int n = s.length();
            boolean[][] g = new boolean[n][n];
            for (int i=0; i<n; i++) Arrays.fill(g[i], true);

            // 进行预处理
            for (int i=n-1; i>=0; i--){
                for (int j=i+1; j<n; j++){
                    g[i][j] = (s.charAt(i) == s.charAt(j) && g[i+1][j-1]);
                }
            }

            // f[i] 表示字符串的前缀 s[0..i] 的最少分割次数
            int[] f = new int[n];
            Arrays.fill(f, Integer.MAX_VALUE);
            for (int i=0; i<n; i++){
                if (g[0][i]){
                    f[i] = 0;
                }else {
                    for (int j=0; j<i; j++){
                        if (g[j + 1][i]) {
                            f[i] = Math.min(f[i], f[j] + 1);
                        }
                    }
                }
            }
            return f[n-1];
        }
    }

}
