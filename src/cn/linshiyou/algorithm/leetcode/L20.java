package cn.linshiyou.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @Author: LJ
 * @Description: 20. 有效的括号
 *
 * 栈：
 */
public class L20 {


    public static void main(String[] args) {

        String s = "(]";
//        String s = "()[]{}";
        Solution solution = new Solution();

        System.out.println(solution.isValid(s));

    }

    static class Solution {
        public boolean isValid(String s) {

            LinkedList<Character> stack = new LinkedList<>();

            for (int i=0; i<s.length(); i++){
                if (!stack.isEmpty()){
                    Character last = stack.getLast();
                    Character c = s.charAt(i);
                    if (last=='(' && c==')' || last=='[' && c==']' || last=='{' && c=='}'){
                        stack.removeLast();
                    }else {
                        stack.addLast(c);
                    }
                }else {
                    stack.addLast(s.charAt(i));
                }
            }

            if (stack.isEmpty()) return true;
            else return false;
        }
    }
}
