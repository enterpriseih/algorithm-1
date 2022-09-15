package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 085. 生成匹配的括号
 *
 * 中等：回溯
 */
public class zero85 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));

    }

    static class Solution {

        private List<String> ans;

        public List<String> generateParenthesis(int n) {

            ans = new ArrayList<>();

            backTrack(new StringBuilder(), 0, 0, n);

            return ans;
        }

        private void backTrack(StringBuilder cur, int open, int close, int max) {

            if (cur.length()==2*max){
                ans.add(cur.toString());
                return;
            }
            if (open<max){
                cur.append('(');
                backTrack(cur, open+1, close, max);
                cur.deleteCharAt(cur.length()-1);
            }
            if (close<open){
                cur.append(')');
                backTrack(cur, open, close+1, max);
                cur.deleteCharAt(cur.length()-1);
            }

        }
    }

}
