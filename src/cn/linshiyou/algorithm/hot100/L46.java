package cn.linshiyou.algorithm.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author LJ
 * @create 2023/2/12
 */
public class L46 {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        new Solution().permute(nums);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();

            List<Integer> output = new ArrayList<>();

            for (int num : nums){
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);


            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first){

            // 所有步数都填完了
            if (first==n){
                res.add(new ArrayList<>(output));
            }

            for (int i=first; i<n; i++){
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first+1);
                // 撤销操作
                Collections.swap(output, first, i);
            }



        }

    }

}
