package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 086. 分割回文子字符串
 *
 *
 * 中等：回溯+动态规划
 */
public class zero86 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[][] strings = solution.partition("google");
        for (int i=0; i<strings.length; i++){
            for (int j=0; j<strings[i].length; j++){
                System.out.print(strings[i][j]+", ");
            }
            System.out.println();
        }

    }



    static class Solution {

        boolean[][] f;
        List<List<String>> ans;
        List<String> cur;
        int n;

        public String[][] partition(String s) {

            ans = new ArrayList<>();
            cur = new ArrayList<>();
            n = s.length();
            f = new boolean[n][n];

            for (int i=0; i<n; i++) Arrays.fill(f[i], true);

            // 双指针  进行预处理
            // "google"
            for (int i=n-1; i>=0; i--){
                for (int j=i+1; j<n; j++){
                    f[i][j] = ((s.charAt(i)==s.charAt(j)) && f[i+1][j-1]);
                }
            }

            dfs(s, 0);

            // 规范输出格式
            int rows = ans.size();
            String[][] ret = new String[rows][];
            for (int i=0; i<rows; i++){
                int cols = ans.get(i).size();
                ret[i] = new String[cols];
                for (int j=0; j<cols; j++){
                    ret[i][j] = ans.get(i).get(j);
                }
            }
            return ret;
        }

        private void dfs(String s, int i) {

            if (i==n){
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int j=i; j<n; j++){
                if (f[i][j]){
                    // 将[i,j+1]这一段字符串加入cur中
                    cur.add(s.substring(i, j+1));
                    dfs(s, j+1);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }

}
