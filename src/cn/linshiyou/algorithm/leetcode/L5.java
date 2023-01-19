package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: LJ
 * @Description: 5. 最长回文子串
 * 左右指针，从中间向两边扩散
 *
 */
public class L5 {


    public static void main(String[] args) {
        String s = "babbbbad";

        System.out.println(new Solution().longestPalindrome(s));

    }
    static class Solution {
        public String longestPalindrome(String s) {

            if (s.length()==1) return s;
            String ans = "";
            for (int i=0; i<s.length(); i++){

                // 回文串长度为奇数
                String s1 = palindrome(s, i, i);
                //回文串长度为偶数
                String s2 = palindrome(s, i, i+1);

                String temp = s1.length()>s2.length()? s1:s2;
                ans =  ans.length()>temp.length() ? ans:temp;

            }
            return ans;
        }

        private String palindrome(String s, int i, int j) {
            int left = i;
            int right = j;
            String ans = "";
            while (left>=0 && right<s.length()){
                if (s.charAt(left)==s.charAt(right)){
                    if (right-left+1>ans.length()){
                        ans = s.substring(left, right+1);
                    }
                    left--;
                    right++;
                }else {
                    break;
                }
            }
            return ans;
        }
    }

}
