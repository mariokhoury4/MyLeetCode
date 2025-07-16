/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 *
 * --> The number of nodes in the list is sz.
 * --> 1 <= sz <= 30
 * --> 0 <= Node.val <= 100
 * --> 1 <= n <= sz
 *
 * Follow up: Could you do this in one pass?
 */
class Solution {
    /**
     * Remove the nth node from the end of the linked list.
     * @param head The head of the linked list
     * @param n The position from the end of the list to remove
     * @return The head of the modified linked list
     */
    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        // 1. Initialize two pointers, fastNode and slowNode
        ListNode fastNode = head;
        ListNode slowNode = head;

        // 2. Move fastNode n steps ahead
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
            // 2.1 If fastNode is null, it means we need to remove the head
            if (fastNode == null) {
                return head.next;
            }
        }

        // 3. Move both pointers until fastNode reaches the end of the list
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        // 4. Remove the nth node from the end
        slowNode.next = slowNode.next.next;

        // 5. Return the head of the modified list
        return head;
    }
}

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}