package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.until.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author LJ
 * @create 2023/4/27
 */
public class L102 {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root==null) return ans;
            LinkedList<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> tmpAns = new ArrayList<>();
                for (int i=0; i<size; i++){
                    TreeNode poll = queue.poll();
                    tmpAns.add(poll.val);
                    if (poll.left!=null) queue.offer(poll.left);
                    if (poll.right!=null) queue.offer(poll.right);
                }
                ans.add(tmpAns);
            }

            return ans;
        }
    }
}
