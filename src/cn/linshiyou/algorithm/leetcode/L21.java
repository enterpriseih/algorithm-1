package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 21. 合并两个有序链表
 *
 * 构建一个新的链表，而后比较大小。
 *
 */
public class L21 {


    public static void main(String[] args) {


    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode ansList = new ListNode();
            ListNode cur = ansList;

            while (list1!=null && list2!=null){
                if (list1.val> list2.val){
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                }else {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
                cur = cur.next;
            }
            if (list1==null)
                cur.next = list2;
            else
                cur.next = list1;

            return ansList.next;
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
