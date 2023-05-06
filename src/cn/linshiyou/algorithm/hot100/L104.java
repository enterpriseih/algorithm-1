package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author LJ
 * @create 2023/4/27
 */
public class L104 {

    class Solution {
        public int maxDepth(TreeNode root) {

            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }

        }
    }

}
