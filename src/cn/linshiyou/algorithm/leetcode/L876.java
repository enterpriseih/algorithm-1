package cn.linshiyou.algorithm.leetcode;


/**
 * @Author: LJ
 * @Description: 23. 合并K个升序链表
 *
 * 优先级队列（大根堆/小根堆）
 *
 *
 */
public class L876 {


    public static void main(String[] args) {


    }

    class Solution {
        public ListNode middleNode(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while (fast!=null){
                fast = fast.next;
                if (fast==null){
                    return slow;
                }
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
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
