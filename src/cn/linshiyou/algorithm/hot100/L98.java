package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.until.TreeNode;

import java.util.LinkedList;

/**
 * @author LJ
 * @create 2023/4/26
 */
public class L98 {

    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValidBST(TreeNode root) {

            LinkedList<TreeNode> stack = new LinkedList<>();
            Long pre = Long.MIN_VALUE;

            while (root!=null || !stack.isEmpty()){

                while (root!=null){
                    stack.addFirst(root);
                    root = root.left;
                }

                root = stack.removeFirst();
                if (root.val>pre){
                    pre = Long.valueOf(root.val);
                }else {
                    return false;
                }
                root = root.right;

            }

            return true;
        }
    }

}
