package cn.linshiyou.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: LJ
 * @Description: 567. 字符串的排列
 *
 */
public class L567 {



    public static void main(String[] args) {
        String s = "abc";
        String t="bbbca";


        System.out.println(new Solution().checkInclusion(s, t));

    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length()>s2.length()) return false;
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();


            for (Character c : s1.toCharArray()){
                need.put(c, need.getOrDefault(c, 0)+1);
            }

            int left = 0;
            int right = 0;
            int valid = 0;

            while (right<s2.length()) {

                Character c = s2.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }

                // 左侧前进。
                if (right - left == s1.length()) {
                    if (valid == need.size()) return true;

                    Character d = s2.charAt(left);
                    left++;

                    if (window.containsKey(d)) {
                        if (need.get(d).equals(window.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }

    }

}
