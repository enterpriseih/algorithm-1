package cn.linshiyou.algorithm.hot100;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author: LJ
 * @create: 2023/2/4
 */
public class L19 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode ans = new ListNode();
            ans.next = head;
            ListNode slow = ans, fast = ans;
            n++;
            while(n--!=0){
                fast = fast.next;
            }
            while (fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;

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
