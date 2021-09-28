public class leetcode25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode temp = head;
        while(i < k){
            if(temp == null) return head;
                temp = temp.next;
                i++;
            }
        ListNode ls = reverseKGroup(temp, k);
        int j = 0;
        ListNode cur = head;
        ListNode prev = null;
        ListNode Next = null;
        while(j < k){
            Next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = Next;
            j++;
        }
        head.next = ls;
        return prev;
    }
}
}
