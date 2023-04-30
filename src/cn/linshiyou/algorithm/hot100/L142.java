package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 *
 * @author LJ
 * @create 2023/4/30
 */
public class L142 {

    public static void main(String[] args) {

    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }

                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {

                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }

            return null;
        }
    }

}
