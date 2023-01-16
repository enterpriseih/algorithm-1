package cn.linshiyou.algorithm.leetcode;


/**
 * @Author: LJ
 * @Description: 83. 删除排序链表中的重复元素
 *
 * 快慢指针问题。
 *
 *
 */
public class L83 {


    public static void main(String[] args) {


    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head==null) return null;

            ListNode slowNode = head;
            ListNode fastNode = head;

            while (fastNode!=null){
                if (fastNode.val!=slowNode.val){
                    slowNode.next = fastNode;
                    slowNode = slowNode.next;
                }
                fastNode = fastNode.next;
            }
            slowNode.next = null;

            return head;
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
