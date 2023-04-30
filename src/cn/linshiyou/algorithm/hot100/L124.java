package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.until.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 124. 二叉树中的最大路径和
 *
 * @author shiyou.lin
 * @date 2023/4/28
 *
 * 一条从父节点延伸下来的路径，不能走入左子树又掉头走右子树，不能两头收益。
 */
public class L124 {

    public static void main(String[] args) {

    }


    class Solution {
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        private int maxGain(TreeNode root) {
            if (root==null) return 0;

            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);

            int priceNewPath = root.val + leftGain + rightGain;

            // 更新答案
            maxSum = Math.max(maxSum, priceNewPath);

            return root.val + Math.max(leftGain, rightGain);
        }
    }

}

/**
 *          1
 *       -2   -3
*       1  3 -2
 *    -1
 */