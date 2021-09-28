public class leetcode23 {
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        while (true){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i < lists.length ; i++){
                if (lists[i] != null){
                    if(lists[i].val < min){
                        min = lists[i].val;
                        index = i;
                    }
                }
            }
            if(min < Integer.MAX_VALUE){
                temp.next = new ListNode();
                temp = temp.next;
                temp.val = min;
                lists[index] = lists[index].next;
            }else{
                break;
            }
        }
        return result.next;
        
    }
}
}
