package cn.linshiyou.algorithm.leetcode;


import java.util.*;

/**
 * @Author: LJ
 * @Description: 23. 合并K个升序链表
 *
 * 优先级队列（大根堆/小根堆）
 *
 *
 */
public class L23 {


    public static void main(String[] args) {


    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length==0) return null;

            ListNode ans = new ListNode();
            ListNode cur = ans;

            // 优先级队列，小根堆
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

            //将k个链表的头结点加入小根堆
            for (ListNode head : lists){
                if (head==null) continue;
                priorityQueue.offer(head);
            }

            while(!priorityQueue.isEmpty()){
                ListNode node = priorityQueue.poll();
                cur.next = node;
                if (node.next != null){
                    priorityQueue.offer(node.next);
                }
                cur = cur.next;
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
