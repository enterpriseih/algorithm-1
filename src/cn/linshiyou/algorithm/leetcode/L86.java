package cn.linshiyou.algorithm.leetcode;


/**
 * @Author: LJ
 * @Description: 86. 分隔链表
 *
 *
 */
public class L86 {


    public static void main(String[] args) {

    }

    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode ans = new ListNode();
            ListNode cur = ans;

            ListNode tmp = head;
            while (tmp!=null){
                if (tmp.val<x){
                    cur.next = new ListNode(tmp.val);
                    tmp.val = Integer.MIN_VALUE;
                    cur = cur.next;
                }
                tmp = tmp.next;
            }
            tmp = head;
            while (tmp!=null){
                if (tmp.val>=x){
                    cur.next = new ListNode(tmp.val);
                    cur = cur.next;
                }
                tmp = tmp.next;
            }

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
