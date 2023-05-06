package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author shiyou.lin
 * @date 2023/5/6
 */
public class L226 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        new Solution().invertTree(treeNode);
    }

    static  class Solution {
        public TreeNode invertTree(TreeNode root) {

            if (root==null) return null;
            if (root.left==null && root.right==null) return root;

            invertTree(root.left);
            invertTree(root.right);
            swap(root);

            return root;

        }

        private void swap(TreeNode root) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }

    }

}
