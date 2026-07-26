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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode temp = head;

        // Check first group
        for (int i = 0; i < k; i++) {
            if (temp == null)
                return head;
            temp = temp.next;
        }

        ListNode prev = null, curr = head, next;
        ListNode prevGroupTail = head;

        // Reverse first group
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        prevGroupTail.next = curr;

        while (true) {
            temp = curr;

            // Check if another full group exists
            for (int i = 0; i < k; i++) {
                if (temp == null)
                    return head;
                temp = temp.next;
            }

            prev = null;
            ListNode groupTail = curr;

            // Reverse current group
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group
            prevGroupTail.next = prev;

            // Connect current group to remaining list
            groupTail.next = curr;

            // Move tail pointer for next iteration
            prevGroupTail = groupTail;
        }
    }
}