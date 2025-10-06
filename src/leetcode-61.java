/**
 * 61. Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n = n + 1;
        }

        k = k % n;
        k = n - k;
        if (k == n) {
            return head;
        }

        temp = head; // [1,2,3,4,5] k = 2, temp = 1 and head = 1

        while (k > 1) {
            temp = temp.next; // temp = 2
            k = k - 1; // k = 1
        }
        ListNode first = temp.next; // first = 3
        temp.next = null; // 2 --> null
        ListNode result = first; // result = 3

        while (first.next != null) {
            first = first.next;
        }
        first.next = head;
        return result;




    }
}