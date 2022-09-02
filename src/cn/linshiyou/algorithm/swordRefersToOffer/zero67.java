package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 067. 最大的异或
 * 使用前缀树来解题。异或相异为1，相同为0
 */
public class zero67 {

    public static void main(String[] args) {

        int[] num = {2,4};

        Solution solution = new Solution();
        int maximumXOR = solution.findMaximumXOR(num);
        System.out.println(maximumXOR);

    }


    static class Solution {
        //前缀树
        Trie root = new Trie();
        //根据条件得知最高位是30位0~30，应该31位
        private static final int HIGH_BIT = 30;
        public int findMaximumXOR(int[] nums) {

            int x = 0;
            for (int i=0; i<nums.length-1; i++){
                // 构建前缀树
                add(nums[i]);


                x = Math.max(x, check(nums[i+1]));
            }
            // 取得最大异或值

            return x;
        }

        //计算异或值
        private int check(int num) {

            int x = 0;
            Trie cur = root;

            for (int i=HIGH_BIT; i>=0; i--){

                int bit = (num >> i) & 1;

                if (bit==0){
                    //根据异或条件，相异为1
                    if (cur.right!=null){
                        x = x*2+1;
                        cur = cur.right;
                    }else {
                        x *= 2;
                        cur = cur.left;
                    }

                }else {
                    if (cur.left!=null){
                        x = x*2+1;
                        cur = cur.left;
                    }else {
                        x *= 2;
                        cur = cur.right;
                    }
                }
            }
            return x;
        }

        /**
         * 将num构建在前缀树中
         * @param num
         */
        private void add(int num) {
            Trie cur = root;

            for (int i=HIGH_BIT; i>=0; i--){

                // 得到num第i位上是0还是1
                int bit = (num>>i) & 1;

                if (bit==0){
                    if (cur.left==null){
                        cur.left = new Trie();
                    }
                    cur = cur.left;
                }else {
                    if (cur.right==null){
                        cur.right = new Trie();
                    }
                    cur = cur.right;
                }

            }

        }
    }

    static class Trie {
        // 左子树指向表示 0 的子节点
        Trie left = null;
        // 右子树指向表示 1 的子节点
        Trie right = null;
    }

}
