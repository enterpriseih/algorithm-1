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
            HashMap<Character, Integer> s1Map = new HashMap<>();
            HashMap<Character, Integer> s2Map = new HashMap<>();


            for (Character c : s1.toCharArray()){
                s1Map.put(c, s1Map.getOrDefault(c, 0)+1);
            }

            int left = 0;
            int fast = s1.length();

            for (int i=left; i<fast; i++){
                Character a = s2.charAt(i);
                if (s1Map.containsKey(a)){
                    s2Map.put(a, s2Map.getOrDefault(a, 0)+1);
                    if (s1Map.get(a).equals(s2Map.get(a))){
                        if (judge(s1Map, s2Map)) return true;
                    }
                }
            }


            while (fast<s2.length()){

                Character old = s2.charAt(left);
                if (s2Map.containsKey(old)){
                    s2Map.put(old, s2Map.get(old)-1);
                }
                left++;

                Character cur = s2.charAt(fast);
                if (s1Map.containsKey(cur)){
                    s2Map.put(cur, s2Map.getOrDefault(cur, 0)+1);
                    if (s1Map.get(cur).equals(s2Map.get(cur))){
                        if (judge(s1Map, s2Map)) return true;
                    }
                }
                fast++;

            }
            return false;
        }

        private boolean judge(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map) {

            Set<Character> set = s1Map.keySet();

            for (Character a : set){
                if (!s1Map.get(a).equals(s2Map.get(a))){
                    return false;
                }
            }

            return true;
        }
    }

}
