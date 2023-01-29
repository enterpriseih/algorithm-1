package cn.linshiyou.algorithm.hot100;

/**
 * 7. 整数反转
 *
 * @author: LJ
 * @create: 2023/1/29
 */
public class L7 {

    public static void main(String[] args) {

//        int x = 2147483651;
//                2147483647
        int x = 45;
        System.out.println(Integer.MAX_VALUE);
        int reverse = new Solution().reverse(x);

        System.out.println(reverse);
    }


    static class Solution {
        public int reverse(int x) {
            int res = 0;
            while(x!=0) {
                //每次取末尾数字
                int tmp = x%10;
                //判断是否 大于 最大32位整数
                if (res>214748364 || (res==214748364 && tmp>7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数
                if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                    return 0;
                }
                res = res*10 + tmp;
                x /= 10;
            }
            return res;
        }
    }

}
