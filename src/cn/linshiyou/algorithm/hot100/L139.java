package cn.linshiyou.algorithm.hot100;

import java.util.*;

/**
 * 139. 单词拆分
 *
 * @author LJ
 * @create 2023/4/29
 */
public class L139 {

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");
        boolean b = new Solution().wordBreak(s, wordDict);

    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet  = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;

            for (int i=1; i<s.length(); i++){
                for (int j=0; j<=i; j++){
//                    System.out.printf("dp[%d]:%b, s\n",j,dp[j],s.substring(j, i));
                    if (dp[j] && wordDict.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }

            return dp[s.length()];
        }
    }

}
