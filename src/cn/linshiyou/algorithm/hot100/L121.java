package cn.linshiyou.algorithm.hot100;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author shiyou.lin
 * @date 2023/4/28
 */
public class L121 {

    public static void main(String[] args) {


    }

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length==0) return 0;
            int now = prices[0];
            int max = 0;

            for (int i=1; i<prices.length; i++){
                int profit = prices[i] - now;
                if (profit<0) now = prices[i];

                max = Math.max(max, profit);

            }


            return max;
        }
    }
}
