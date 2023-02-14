package cn.linshiyou.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 48. 旋转图像
 *
 * @author LJ
 * @create 2023/2/14
 */
public class L48 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        new Solution().rotate(matrix);

    }


    static class Solution {
        public void rotate(int[][] matrix) {

            if (matrix.length==0 || matrix.length != matrix[0].length){
                return;
            }
            int nums = matrix.length;
            //先沿右上 - 左下的对角线翻转（270°+ 一次镜像）
            for (int i=0; i<nums; i++){
                for (int j=0; j<nums-1; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[nums-1-j][nums-1-i];
                    matrix[nums-1-j][nums-1-i] = temp;
                }
            }

            //再沿水平中线上下翻转（+−180°+ 一次镜像）
            for (int i=0; i<(nums>>1); i++){
                for (int j=0; j<nums; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[nums-1-i][j];
                    matrix[nums-1-i][j] = temp;
                }
            }

        }
    }

}
