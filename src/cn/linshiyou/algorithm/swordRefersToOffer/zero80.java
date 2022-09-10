package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 080. 含有 k 个元素的组合
 * 不会
 * 中等：递归+一种剪枝的思想，依次遍历
 */
public class zero80 {

    public static void main(String[] args) {

        int n=4;
        int k=2;

        Solution solution = new Solution();
        System.out.println(solution.combine(n, k));

    }

    static class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
        }

        public void dfs(int cur, int n, int k) {
            // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
            if (temp.size() + (n - cur + 1) < k) {
                return;
            }
            // 记录合法的答案
            if (temp.size() == k) {
                // 在java中是对对象的引用
                ans.add(new ArrayList<>(temp));
                return;
            }
            // 考虑选择当前位置
            temp.add(cur);
            dfs(cur + 1, n, k);
            temp.remove(temp.size() - 1);
            // 考虑不选择当前位置
            dfs(cur + 1, n, k);
        }
    }

}
