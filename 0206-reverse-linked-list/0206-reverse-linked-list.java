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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head, t = head, temp2 = head, t2 = head;
        int len = 2;
        while (temp.next.next != null) {
            temp = temp.next;
            len++;
        }
        if (len < 3) {
            t = temp.next;
            temp.next = null;
            t.next = head;
            head = t;
            return head;
        } else {
            t = temp.next;
            t.next = t2.next;
            head = t;
            t2.next = null;
            temp.next = t2;
        }

        int i = 1;
        temp2 = head;
        while (i < len / 2) {
            temp = temp2;
            t2 = temp2.next;

            for (int a = i; a < len - i - 1; a++) temp = temp.next;
            if (temp2.next == temp) {
                t = temp.next;
                temp.next = t.next;
                t.next = t2;
                temp2.next = t;
                return head;
            }
            t = temp.next;
            temp.next = t.next;
            t.next = t2.next;
            temp2.next = t;
            t2.next = temp.next;
            temp.next = t2;

            temp2 = temp2.next;
            i++;
        }
        return head;
    }
}