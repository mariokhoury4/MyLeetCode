/**
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * --> The number of nodes in both lists is in the range [0, 50].
 * --> -100 <= Node.val <= 100
 * --> Both list1 and list2 are sorted in non-decreasing order.
 */
class Solution {
    /**
     * Merge two sorted linked lists.
     * @param list1 first sorted linked list
     * @param list2 second sorted linked list
     * @return the head of the merged sorted linked list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Check if either list is null and return the other list.
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 2. Initialize a temporary node to build the merged list.
        ListNode tempNode = new ListNode(0);

        // 3. Initialize a result node to keep track of the head of the merged list.
        ListNode resultNode = tempNode;

        // 4. Iterate through both lists and compare their values.
        while (list1 != null && list2 != null) {
            // 4.1 Compare the values of the current nodes in both lists.
            if (list1.val < list2.val) {
                tempNode.next = list1;
                list1 = list1.next;
                tempNode = tempNode.next;
            } else {
                tempNode.next = list2;
                list2 = list2.next;
                tempNode = tempNode.next;
            }
        }

        // 5. If one of the lists is not fully traversed, append the remaining nodes to the merged list.
        if (list1 != null) {
            tempNode.next = list1;
        } else {
            tempNode.next = list2;
        }
        // 6. Finally, return the next node of the resultNode, which is the head of the merged list.
        return resultNode.next;

    }
}