/**
 * 23. Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.

 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted linked list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 *
 * --> k == lists.length
 * --> 0 <= k <= 104
 * --> 0 <= lists[i].length <= 500
 * --> -104 <= lists[i][j] <= 104
 * --> lists[i] is sorted in ascending order.
 * --> The sum of lists[i].length will not exceed 104.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. Initialize a temporary node to build the merged list.
        ListNode tempNode = new ListNode(0);

        // 2. Initialize a result node to keep track of the head of the merged list.
        ListNode resultNode = tempNode;

        while (true) {
            int smallestIndex = findSmallest(lists);
            if (smallestIndex == -1) {
                break;
            }
            tempNode.next = lists[smallestIndex];
            tempNode = tempNode.next;
            lists[smallestIndex] = lists[smallestIndex].next;
        }

        return resultNode.next;
    }

    /**
     * Find the smallest node among the heads of the k linked lists.
     * @param lists array of linked lists
     * @return the smallest node
     */
    private int findSmallest(ListNode[] lists) {
        ListNode smallestNode = null;
        int smallestIndex = -1;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (smallestNode == null) {
                smallestNode = lists[i];
                smallestIndex = i;
            } else {
                if (lists[i].val < smallestNode.val) {
                    smallestNode = lists[i];
                    smallestIndex = i;
                }
            }
        }
        return smallestIndex;
    }
}