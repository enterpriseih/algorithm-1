package cn.linshiyou.algorithm.hot100;



import cn.linshiyou.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LJ
 * @create 2023/4/26
 */
public class L94 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> list = new Solution().inorderTraversal(treeNode);
        System.out.println(list.toString());
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();

            while (root!=null || !stack.isEmpty()){

                while (root!=null){
                    stack.addFirst(root);
                    root = root.left;
                }

                root = stack.removeFirst();
                ans.add(root.val);

                root = root.right;
            }
            return ans;
        }
    }


}
