package cn.linshiyou.algorithm.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 *
 * @author LJ
 * @create 2023/2/7
 */
public class L23 {

    public static void main(String[] args) {

    }


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n==0) return null;
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode listNode: lists) {
                if (listNode!=null){
                    priorityQueue.add(listNode);
                }
            }

            ListNode ans = new ListNode();
            ListNode cur = ans;
            while (!priorityQueue.isEmpty()){
                ListNode poll = priorityQueue.poll();
                cur.next = poll;
                poll = poll.next;
                if (poll!=null){
                    priorityQueue.add(poll);
                }
                cur = cur.next;
            }

            return ans.next;
        }
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
