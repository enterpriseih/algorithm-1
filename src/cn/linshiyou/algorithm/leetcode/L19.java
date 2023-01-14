package cn.linshiyou.algorithm.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: LJ
 * @Description: 23. 合并K个升序链表
 *
 * 优先级队列（大根堆/小根堆）
 *
 *
 */
public class L19 {


    public static void main(String[] args) {


    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {


            ListNode pre = new ListNode();
            pre.next = head;
            ListNode cur = head;
            ListNode ans = pre;

            while (n--!=0){

                cur = cur.next;
            }
            while (cur!=null){
                pre = pre.next;
                cur = cur.next;
            }

            if (pre!=null)
                pre.next = pre.next.next;


            return ans.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
