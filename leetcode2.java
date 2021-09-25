class leetcode2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        int buffer = 0;
        while (l1 != null && l2 != null){
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = (l1.val + l2.val + buffer) % 10;
            if (l1.val + l2.val + buffer >= 10){
                buffer = 1;
            }else{
                buffer = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null){
            while (l1 != null){
                temp.next = new ListNode();
                temp = temp.next;
                temp.val = (l1.val + buffer) % 10;
                if (l1.val + buffer >= 10){
                    buffer = 1;
                }else{
                    buffer = 0;
                }
                l1 = l1.next;
            }
        }else if (l2 != null){
            while (l2 != null){
                temp.next = new ListNode();
                temp = temp.next;
                temp.val = (l2.val + buffer) % 10;
                if (l2.val + buffer >= 10){
                    buffer = 1;
                }else{
                    buffer = 0;
                }
                l2 = l2.next;
            }
        }
        if (buffer == 1){
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = 1;
        }
        return result.next;

    }
}