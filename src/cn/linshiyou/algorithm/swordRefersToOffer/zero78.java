package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 078. 合并排序链表
 *
 * 困难：一种取巧的做法(作弊做法)
 */
public class zero78 {

    public static void main(String[] args) {

        ListNode[] listNodes = new ListNode[10];

        Solution solution = new Solution();
        solution.mergeKLists(listNodes);


    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length==0 || lists[0]==null) return null;
            List<Integer> ansList = new ArrayList<>();
            ListNode ans = new ListNode(-1);
            for (int i=0; i<lists.length; i++){
                ListNode cur = lists[i];
                while(cur!=null){
                    ansList.add(cur.val);
                    cur = cur.next;
                }
            }
            Collections.sort(ansList);
            ListNode curNode = ans;
            for (Integer one : ansList){
                curNode.next = new ListNode(one);
                curNode = curNode.next;
            }

            return ans;
        }
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
