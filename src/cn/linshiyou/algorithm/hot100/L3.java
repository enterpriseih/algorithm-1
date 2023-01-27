package cn.linshiyou.algorithm.hot100;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author: LJ
 * @create: 2023/1/27
 */
public class L3 {

    public static void main(String[] args) {
        String s  = "aab";
        int i = new Solution().lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;

            Set<Character> windows = new HashSet<>();

            int max = 0;
            int left = 0, right = 0;

            while (right<s.length()){
                char c = s.charAt(right);
                right++;

                while (windows.contains(c)){
                    char d = s.charAt(left);
                    left++;
                    windows.remove(d);
                    if (c==d) break;
                }

                windows.add(c);
                max = Math.max(max, windows.size());

            }
            return max;
        }
    }

}
