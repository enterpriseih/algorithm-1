package cn.linshiyou.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * @author: LJ
 * @create: 2023/2/3
 */
public class L17 {


    public static void main(String[] args) {
        String digits = "23";
        List<String> list = new Solution().letterCombinations(digits);
        System.out.println(list);
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.length()==0) return new ArrayList<>();

            List<List<Character>> list = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            char tmp = 'a';
            for (int i=0; i<=9; i++){
                if (i==0||i==1){
                    list.add(new ArrayList<>());
                    continue;
                }

                if (i==7 ||i==9){
                    list.add(Arrays.asList(tmp++, tmp++, tmp++, tmp++));
                    continue;
                }

                list.add(Arrays.asList(tmp++, tmp++, tmp++));
            }

            backtrack(list, ans, digits, 0, new StringBuilder());

            return ans;
        }

        private void backtrack(List<List<Character>> list, List<String> ans, String digits, int index, StringBuilder stringBuilder) {
            if (stringBuilder.length()==digits.length()){
                ans.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }else {
                Integer integer = digits.charAt(index) - '0';
                for (int i=0; i<list.get(integer).size(); i++){
                    stringBuilder.append(list.get(integer).get(i));
                    backtrack(list, ans, digits,index+1, stringBuilder);
                    stringBuilder.deleteCharAt(index);
                }

            }
        }
    }

}
