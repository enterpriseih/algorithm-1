package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.until.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author LJ
 * @create 2023/4/27
 */
public class L105 {

    public static void main(String[] args) {

    }

    class Solution {
        private Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            if (n==1) return new TreeNode((preorder[0]));

            //  preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
            indexMap = new HashMap<Integer, Integer>();

            for (int i=0; i<n; i++){
                indexMap.put(inorder[i], i);
            }


            return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);

        }

        private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorderRoot = preorder_left;

            // 在中序遍历中定位根节点
            int inorderRoot = indexMap.get(preorder[preorderRoot]);


            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorderRoot]);

            // 得到左子树中的节点数目
            int size_left_subtree = inorderRoot - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorderRoot - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorderRoot + 1, inorder_right);

            return root;
        }
    }

}
