package cn.linshiyou.algorithm.contest.leetCodeContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 3. 弹珠游戏
 */
public class three {

    public static void main(String[] args) {
        int num = 69;
        String[] plate = {
//                ".....","..E..",".WO..","....."
                "W.W.WE..",".WWWEW..","EWW.WE.E","E.W.E.E.",".OEOO.EO","WE.WOE.W","WW...E..",".WEWO..O","E....E..",".OWE...."
        };
        Solution solution = new Solution();
        int[][] ints = solution.ballGame(num, plate);
        System.out.println(ints[0][0]);

    }

    static class Solution {
        // 不能在四角打入,只能从.处打入
        public int[][] ballGame(int num, String[] plate) {
            int n = plate.length;
            int m = plate[0].length();
            List<int[]> list = new ArrayList<>();

            // 从最上面进入,第一格和最后一格不能进入
            for (int j=1; j<m-1; j++){
                if (go(0, j, -1, plate, num, 2)){
                    int[] one = {0, j};
                    list.add(one);
                }
            }
            // 从最左面进入,第一格和最后一格不能进入
            for (int i=1; i<n-1; i++){
                if (go(i, 0, -1, plate, num, 6)){
                    int[] one = {i, 0};
                    list.add(one);
                }
            }
            // 从最下面进入,第一格和最后一格不能进入
            for (int j=1; j<m-1; j++){
                if (go(n-1, j, -1, plate, num, 8)){
                    int[] one = {n-1, j};
                    list.add(one);
                }
            }
            // 从最右面进入,第一格和最后一格不能进入
            for (int i=1; i<n-1; i++){
                if (go(i, m-1, -1, plate, num, 4)){
                    int[] one = {i, m-1};
                    list.add(one);
                }
            }



            int[][] ans = new int[list.size()][2];
            for (int i=0; i<list.size(); i++){
                ans[i][0] = list.get(i)[0];
                ans[i][1] = list.get(i)[1];
            }
            return ans;
        }

        // 前进,2下，6右，4左， 8上
        private boolean go(int row, int col, int bu, String[] plate, int num, int fang) {
            int n = plate.length;
            int m = plate[0].length();
            char op = plate[row].charAt(col);
            if (op!='.') return false;
            while (row<n && row>=0 && col >=0 && col <m && bu <=num){
                op = plate[row].charAt(col);
                if (fang==2){
                    if (op=='.') row++;
                    else if (op=='W'){
                        col++;
                        fang=6;
                    }
                    else if (op=='E'){
                        col--;
                        fang = 4;
                    }
                }else if (fang==4){
                    if (op=='.') col--;
                    else if (op=='W'){
                        row++;
                        fang=2;
                    }
                    else if (op=='E'){
                        row--;
                        fang=8;
                    }
                }else if (fang==6){
                    if (op=='.') col++;
                    else if (op=='W'){
                        row--;
                        fang=8;
                    }
                    else if (op=='E'){
                        row++;
                        fang=2;
                    }
                }else {
                    if (op=='.') row--;
                    else if (op=='W'){
                        col--;
                        fang=4;
                    }
                    else if (op=='E'){
                        col++;
                        fang=6;
                    }
                }
                bu++;
                if (op=='O'&& bu<=num) return true;
            }
            return false;
        }
    }
}
