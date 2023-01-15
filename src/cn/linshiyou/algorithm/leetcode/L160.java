package cn.linshiyou.algorithm.leetcode;


import cn.linshiyou.algorithm.swordRefersToOffer.zero22Ⅱ;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: LJ
 * @Description: 160. 相交链表
 *
 * 方法一：Hash
 * 方法二: 双指针
 *
 */
public class L160 {


    public static void main(String[] args) {


    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }

/**
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            Set<ListNode> set = new HashSet<>();
            while (headA!=null){
                set.add(headA);
                headA = headA.next;
            }
            while (headB!=null){
                if (set.contains(headB)) return headB;

                headB = headB.next;
            }
            return null;
        }
    }
**/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
