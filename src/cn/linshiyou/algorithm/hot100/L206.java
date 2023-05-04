package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.ListNode;

/**
 * 206. 反转链表
 *
 * @author shiyou.lin
 * @date 2023/5/4
 */
public class L206 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head==null) return null;
            ListNode root = new ListNode(-1);
//            root.next = head;
            ListNode cur = head;
            ListNode pre = null;

            while (cur!=null){

                root.next = cur;
                cur = cur.next;
                root.next.next = pre;
                pre = root.next;

            }
            return root.next;
        }
    }

}
