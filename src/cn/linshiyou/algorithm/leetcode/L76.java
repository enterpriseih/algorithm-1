package cn.linshiyou.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LJ
 * @Description: 76. 最小覆盖子串
 * 滑动窗口，优秀的做法
 *
 */
public class L76 {



    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t="ABC";


        System.out.println(new Solution().minWindow(s, t));

    }


    static class Solution {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        public String minWindow(String s, String t) {


            for (char c : t.toCharArray()){
                need.put(c, need.getOrDefault(c, 0)+1);
            }

            int left = 0;
            int right = 0;
            // 有效数字
            int valid = 0;

            int start = 0, len = Integer.MAX_VALUE;

            while (right<s.length()){
                char c = s.charAt(right);
                right++;


                // 如果需要字符c就存入到滑动窗口中，并将数字+1
                if (need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0)+1);
                    // 如果字符c个数相同，说明这个c这个字符已经满足了
                    if (need.get(c).equals(window.get(c))){
                        valid++;
                    }
                }

                // 判断左侧窗口是否要收缩
                while (valid==need.size()){
                    // 更新最小覆盖子串
                    if (right-left<len){
                        start = left;
                        len = right - left;
                    }

                    //滑动窗口收缩，将最右侧字符移出
                    char d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)){
                        if (window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d, window.get(d)-1);
                    }

                }


            }


            return len == Integer.MAX_VALUE? "": s.substring(start, start+len);
        }

    }
}
