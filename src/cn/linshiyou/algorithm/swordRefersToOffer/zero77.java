package cn.linshiyou.algorithm.swordRefersToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 077. 链表排序
 *
 * 中等：简单暴力方法，读出链表数据，排序之后再重构链表
 * 更优秀的做法是通过归并排序实现，利用快慢指针找到中点而后递归
 */
public class zero77 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head==null) return null;
            ListNode ans = new ListNode(0);
            List<Integer> sort = new ArrayList<>();
            while (head!=null){
                sort.add(head.val);
                head = head.next;
            }
            Collections.sort(sort);
            ListNode cur = ans;
            for (Integer one : sort){
                cur.next = new ListNode(one);
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
