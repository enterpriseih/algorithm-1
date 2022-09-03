package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 069. 山峰数组的顶部
 * 简单：暴力遍历时间复杂度 O(n)
 * 二分法与上一题有相似之处：时间复杂度：O(log n)
 */
public class zero69 {

    public static void main(String[] args) {

        int[] arr = {1,3,5,4,2};
        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(arr));

    }

    static class Solution {
        public int peakIndexInMountainArray(int[] arr) {

            int n = arr.length;
            int left=0;
            int right=n-1;
            int res = -1;

            //找到最小的满足arr[res]>arr[res+1]的下标res
            while (left<=right){
                int mid = left + (right-left)/2;
                if (arr[mid]>arr[mid+1]){
                    res = mid;
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }

            return res;
        }
    }

}
