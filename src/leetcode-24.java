/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Explanation:
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 *
 * Example 4:
 * Input: head = [1,2,3]
 * Output: [2,1,3]
 *
 * Constraints:
 *
 * --> The number of nodes in the list is in the range [0, 100].
 * --> 0 <= Node.val <= 100
 */
class Solution {
    /**
     * Swap every two adjacent nodes in a linked list.
     * @param head the head of the linked list
     * @return the head of the modified linked list
     */
    public ListNode swapPairs(ListNode head) {
        // 1. Check if the list is empty or has only one node.
        if (head == null || head.next == null) {
            return head;
        }

        // 2. Initialize a new head node to facilitate swapping.
        ListNode newHead = new ListNode(0);
        ListNode prevNode = newHead;

        // 3. While there are at least two nodes to swap.
        while (head != null && head.next != null) {
            // 4. identify the first and second nodes to swap.
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 5. Perform the swap.
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 6. Move pointers forward for next swap
            prevNode = firstNode;
            head = firstNode.next;
        }
        // 7. Return the next node of newHead, which is the new head of the modified list.
        return newHead.next;
    }
}