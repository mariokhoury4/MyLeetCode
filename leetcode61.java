public class leetcode61 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        if(k == 0) return head;
        int counter = 1;
        ListNode nb = head;
        while(nb.next != null){
            nb = nb.next;
            counter = counter + 1;
        }
        
        k = k % counter;
        if(k == 0) return head;
        k = counter - k - 1;
        ListNode temp = head;
        ListNode result = head;
        
        for(int i = 0; i < k; i++){
            temp = temp.next;
            result = result.next;
        }
        result = result.next;
        temp.next = null;
        
        ListNode returne = result;
        while(result.next != null){
            result = result.next;
        }
        result.next = head;
        return returne;
      
    }
}
}
