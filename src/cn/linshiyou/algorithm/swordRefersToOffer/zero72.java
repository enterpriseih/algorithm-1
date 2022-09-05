package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 072. 求平方根
 * 简单：调用库函数
 */
public class zero72 {

    public static void main(String[] args) {
        int x = 4;
        Solution solution = new Solution();

        System.out.println(solution.mySqrt(x));
    }

    static class Solution {
        public int mySqrt(int x) {
            return (int) Math.sqrt(x);
        }
    }
}
