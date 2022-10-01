package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 096. 字符串交织
 * 想法：先思考出状态转移方程：
 *
 * 中等：动态规划
 */
public class zero96 {

    public static void main(String[] args) {

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        Solution solution = new Solution();
        System.out.println(solution.isInterleave(s1, s2, s3));

    }

    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {

            int n = s1.length(), m=s2.length(), t=s3.length();

            if (n+m!=t) return false;

            boolean[][] f = new boolean[n+1][m+1];
            f[0][0] = true;//边界条件，

            for (int i=0; i<=n; i++){
                for (int j=0; j<=m; j++){
                    int p = i+j-1;
                    if (i>0){
                        f[i][j] = f[i][j] || (f[i-1][j] && s1.charAt(i-1)==s3.charAt(p));
                    }
                    if (j>0){
                        f[i][j] = f[i][j] || (f[i][j-1] && s2.charAt(j-1)==s3.charAt(p));
                    }

                }
            }


            return f[n][m];
        }
    }

}
