package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.until.TreeNode;

import java.util.*;

/**
 * 114. 二叉树展开为链表
 *
 * @author shiyou.lin
 * @date 2023/4/28
 */
public class L114 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        new Solution().flatten(root);
        System.out.println(root);
    }


    static class Solution {
        public void flatten(TreeNode root) {
        // 中左右
            if (root==null) return;
            List<Integer> nums = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();

            TreeNode tmpRoot = root;
            while (tmpRoot!=null || !stack.isEmpty()){

                while (tmpRoot!=null){
                    nums.add(tmpRoot.val);
                    stack.addFirst(tmpRoot);
                    tmpRoot = tmpRoot.left;
                }

                tmpRoot = stack.removeFirst().right;
            }

            root.val = nums.remove(0);
            root.left = null;

            for (int num : nums){
                root.right = new TreeNode(num);
                root = root.right;

            }

        }
    }

}
