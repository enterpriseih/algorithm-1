package cn.linshiyou.algorithm.hot100;

import java.util.Arrays;

/**
 * @author LJ
 * @create 2023/4/23
 */
public class L79 {

    public static void main(String[] args) {


        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "Ac";
        boolean exist = new Solution().exist(board, word);
        System.out.println(exist);

    }


    static class Solution {
        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;
            boolean[][] booleans = new boolean[n][m];
            for (int i=0; i<n; i++){
                Arrays.fill(booleans[i], false);
            }
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    boolean flag = dfs(board, i, j, 0, word, booleans);
                    if (flag) return true;
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, int row, int col, int i, String word, boolean[][] booleans) {
            int n = board.length;
            int m = board[0].length;

            if (row<0 || row>=n || col<0 || col>=m || i>=word.length() ||  booleans[row][col] || board[row][col]!=word.charAt(i)) return false;
            if (i==word.length()-1) return true;
            booleans[row][col] = true;
            boolean upFlag = dfs(board, row-1, col, i+1, word, booleans);
            boolean downFlag =dfs(board, row+1, col, i+1, word, booleans);
            boolean rightFlag =dfs(board, row, col+1, i+1, word, booleans);
            boolean leftFlag =dfs(board, row, col-1, i+1, word, booleans);
            booleans[row][col] = false;

            return upFlag || downFlag || rightFlag || leftFlag;
        }
    }
}
