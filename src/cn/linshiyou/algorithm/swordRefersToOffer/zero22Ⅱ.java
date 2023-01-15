package cn.linshiyou.algorithm.swordRefersToOffer;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 022. 链表中环的入口节点
 *
 * 快慢指针 + 数学推导
 *
 */
public class zero22Ⅱ {

    public static void main(String[] args) {


    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            if (head == null) return null;
            ListNode slow = head;
            ListNode fast = head;

            while (fast!=null){

                fast = fast.next;
                if (fast==null) return null;
                fast = fast.next;
                slow = slow.next;
                if (fast==slow) break;
            }
            if (fast == null) return null;
            ListNode pre = head;
            while (pre!=slow){
                pre = pre.next;
                slow = slow.next;
            }
            return pre;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
