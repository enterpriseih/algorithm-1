package cn.linshiyou.algorithm.hot100;

import java.util.logging.Level;

/**
 * 5. 最长回文子串
 *
 * @author: LJ
 * @create: 2023/1/28
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/solution/shi-pin-tu-jie-dong-tai-gui-hua-zui-chang-hui-wen-/
 */
public class L5 {

    public static void main(String[] args) {
        String s = "aaaa";

        String s1 = new Solution().longestPalindrome(s);
        System.out.println(s1);

    }


    static class Solution {
        public String longestPalindrome(String s) {
            if (s.length()==1) return s;

            int len = s.length();
            int maxLen = 1;
            int begin = 0;
            boolean[][] dp = new boolean[len][len];

            for (int i=0; i<len; i++){
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();

            for (int L=2; L<=len; L++){
                for (int i=0; i<len; i++){
                    // 有边界
                    int j = L+i-1;
                    if(j>=len) break;

                    if (charArray[i]==charArray[j]){

                        if (j-i<3){
                            dp[i][j] = true;
                        }else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }

                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }

}
