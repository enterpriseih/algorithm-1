package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.ListNode;

/**
 * 61. 旋转链表
 *
 * @author LJ
 * @create 2023/2/16
 */
public class L61 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if (k==0 || head == null || head.next==null){
                return head;
            }
            int n = 1;
            ListNode iter = head;
            while (iter.next!=null){
                n++;
                iter = iter.next;
            }
            int add = n - k%n;

            if (add==n){
                return head;
            }

            iter.next = head;
            while (add>0){
                iter = iter.next;
                add--;
            }
            ListNode ans = iter.next;
            iter.next = null;
            return ans;
        }
    }



}
