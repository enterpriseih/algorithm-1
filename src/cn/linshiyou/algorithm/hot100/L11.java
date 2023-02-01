package cn.linshiyou.algorithm.hot100;

/**
 * 11. 盛最多水的容器
 *
 * @author: LJ
 * @create: 2023/2/1
 */
public class L11 {

    public static void main(String[] args) {

    }

    class Solution {
        public int maxArea(int[] height) {

            int n = height.length;
            int max = 0;
            int left = 0, right = height.length-1;

            while (left!=right){
                int a = height[left];
                int b = height[right];
                int tmp = Math.min(a, b) * (right-left);
                max = Math.max(tmp, max);
                if (a>b){
                    right--;
                }else {
                    left++;
                }
            }

            return max;
        }
    }
}
