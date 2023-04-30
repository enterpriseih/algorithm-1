package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LJ
 * @create 2023/4/30
 */
public class L141 {

    public static void main(String[] args) {

    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 快慢指针
            ListNode slow = head;
            ListNode fast = head;

            while (slow!=null && fast!=null){

                if (fast.next==null || fast.next.next==null) return false;

                slow = slow.next;
                fast = fast.next.next;
                if (slow==fast) return true;

            }

            return false;
        }
    }
}
