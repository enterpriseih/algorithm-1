package cn.linshiyou.algorithm.hot100;

import cn.linshiyou.algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * @author shiyou.lin
 * @date 2023/5/6
 */
public class L234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        new Solution().isPalindrome(head);

    }


    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head==null) return false;
            boolean isOdd = false;
            List<Integer> list = new ArrayList<>();
            ListNode slow = head;
            ListNode fast = head;

            while (fast!=null){
                list.add(slow.val);
                fast = fast.next;
                if (fast==null){
                    isOdd = true;
                    break;
                }

                fast = fast.next;
                slow = slow.next;
            }

            if (isOdd && list.size()>1){
                list.remove(list.size()-1);
                slow = slow.next;
            }

            while (slow!=null){
                Integer remove = list.remove(list.size() - 1);
                if (remove!=slow.val) return false;
                slow = slow.next;
            }

            return true;
        }
    }

}
