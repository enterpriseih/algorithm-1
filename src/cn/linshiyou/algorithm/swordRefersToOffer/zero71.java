package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 071. 按权重生成随机数
 * 中等：前缀和+二分查找
 */
public class zero71 {

    public static void main(String[] args) {

        int[] w = {1,1,1,1,0};
        Solution solution = new Solution(w);
        System.out.println(solution.pickIndex());

    }

    static class Solution {

        int right[];
        int total;

        public Solution(int[] w) {

            right = new int[w.length];
            right[0] = w[0];

            for (int i=1; i< w.length; i++){
                right[i] = right[i-1] + w[i];
            }

            total = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            int x = (int) (Math.random()*total+1);
            return binarySearch(x);
        }

        private int binarySearch(int x) {
            int low = 0;
            int high = right.length-1;

            while (low<=high){
                int mid = low + (high-low)/2;

                if (right[mid]<x){
                    low = mid+1;
                }else {
                    high = mid-1;
                }

            }

            return low;
        }
    }

}
