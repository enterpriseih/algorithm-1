package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LJ
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 *
 *
 */
public class zero22 {

    public static void main(String[] args) {


    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode cur = head;
            ListNode pre = head;

            while (k-->0){
                cur = cur.next;
            }

            while (cur!=null){
                pre = pre.next;
                cur = cur.next;
            }

            return pre;
        }
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
