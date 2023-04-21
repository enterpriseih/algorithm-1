package cn.linshiyou.algorithm.hot100;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * @author LJ
 * @create 2023/4/22
 */
public class L70 {

    public static void main(String[] args) {

        new Solution().climbStairs(3);
    }


    static class Solution {
        public int climbStairs(int n) {
            if (n<=0) return 0;
            if (n==1) return 1;
            if (n==2) return 2;

            int pre = 1;
            int cur = 2;
            int temp = 0;
            for (int i=3; i<=n; i++){
                temp = cur;
                cur += pre;
                pre = temp;
            }
            return cur;
        }
    }
}
