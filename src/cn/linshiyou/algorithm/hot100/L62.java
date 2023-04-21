package cn.linshiyou.algorithm.hot100;

import java.util.Arrays;

/**
 * 62. 不同路径
 *
 * @author LJ
 * @create 2023/4/16
 */
public class L62 {
    public static int minInsertionsToMakeValid(String word) {
        int n = word.length();
        int[][] dp = new int[n + 1][3];
        final int INF = (int) 1e9;
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, INF));
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int k = (word.charAt(i) - 'a' + 1 - j + 3) % 3;
                dp[i + 1][(j + k) % 3] = Math.min(dp[i + 1][(j + k) % 3], dp[i][j] + k);
                dp[i + 1][(j + 3) % 3] = Math.min(dp[i + 1][(j + 3) % 3], dp[i][j] + 3);
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(minInsertionsToMakeValid("aaa")); // 输出: 6
        System.out.println(minInsertionsToMakeValid("b")); // 输出: 2
        System.out.println(minInsertionsToMakeValid("abc")); // 输出: 0
    }

}
