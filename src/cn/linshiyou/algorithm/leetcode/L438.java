package cn.linshiyou.algorithm.leetcode;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 438. 找到字符串中所有字母异位词
 *
 */
public class L438 {



    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t="abc";


        System.out.println(new Solution().findAnagrams(s, t));

    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length()<p.length()) return new ArrayList<>();

            List<Integer> ans = new ArrayList<>();

            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (Character c: p.toCharArray()){
                need.put(c, need.getOrDefault(c, 0)+1);
            }

            int left = 0;
            int right = 0;
            int valid = 0;

            while (right<s.length()){

                Character a = s.charAt(right);
                right++;

                if (need.containsKey(a)){
                    window.put(a, window.getOrDefault(a, 0)+1);
                    if (need.get(a).equals(window.get(a))){
                        valid++;
                    }
                }

                if (right-left==p.length()){

                    if (valid==need.size()) ans.add(left);
                    Character b = s.charAt(left);
                    left++;


                    if (window.containsKey(b)){
                        if (window.get(b).equals(need.get(b))){
                            valid--;
                        }
                        window.put(b, window.get(b)-1);

                    }

                }
            }

            return ans;
        }
    }

}
