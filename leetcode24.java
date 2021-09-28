public class leetcode24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
class Solution {
    
    public ListNode recursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head.next;
        ListNode curr = head;
        ListNode nextNode = recursive(prev.next);
        prev.next = curr;
        curr.next =nextNode;
        return prev;
    }
    
    public ListNode swapPairs(ListNode head) {
        return recursive(head);
    }
}
}
