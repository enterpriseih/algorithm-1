package cn.linshiyou.algorithm.leetcode;


/**
 * @Author: LJ
 * @Description: 86. 分隔链表
 *
 *
 */
public class L86 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);
        ListNode partition = new Solution().partition(head, 3);
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode small = new ListNode();
            ListNode tmpSmall = small;
            ListNode lager = new ListNode();
            ListNode tmpLager = lager;

            while (head!=null){

                if (head.val<x){
                    tmpSmall.next = head;
                    tmpSmall = tmpSmall.next;

                }else {
                    tmpLager.next = head;
                    tmpLager = tmpLager.next;
                }

                // 断开原链表
                ListNode temp = head.next;
                head.next = null;
                head = temp;

            }
            tmpSmall.next = lager.next;

            return small.next;
        }
    }

/* 法一
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
*/


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
