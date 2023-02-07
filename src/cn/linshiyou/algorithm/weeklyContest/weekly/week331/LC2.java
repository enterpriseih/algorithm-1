package cn.linshiyou.algorithm.weeklyContest.weekly.week331;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LJ
 * @create 2023/2/5
 *
 * 前缀和
 */
public class LC2 {

    public static void main(String[] args) {

    }

    /**
     *   0 1 2 3 4 5
     * 0 0 1 1 2 3 4
     *
     */

    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {

            Set<Character> set = new HashSet<Character>(){{
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }};

            int n = words.length;
            int[] dp = new int[n+1];
            int[] ans = new int[queries.length];

            for (int i=0; i<n; i++){
                char a = words[i].charAt(0);
                char b = words[i].charAt(words[i].length()-1);
                if (set.contains(a) && set.contains(b)){
                    dp[i+1] = dp[i] + 1;
                }else {
                    dp[i+1] = dp[i];
                }
            }
            System.out.println(Arrays.toString(dp));


            for (int i=0; i< queries.length; i++){
                int left = queries[i][0]+1;
                int right = queries[i][1]+1;

                ans[i] = dp[right] - dp[left-1];

            }

            return ans;
        }
    }

}