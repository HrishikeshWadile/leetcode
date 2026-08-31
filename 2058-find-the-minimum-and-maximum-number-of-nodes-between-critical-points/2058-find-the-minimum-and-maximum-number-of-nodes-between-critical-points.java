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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max = 0, min = 100001, i = 1, l = 0, p = head.val, c, n;
        ListNode temp = head;
        while (temp.next != null) {
            c = temp.val;
            n = temp.next.val;
            if (p < c && c > n || p > c && c < n) {
                if (l == 0) {
                    l = i;
                } else {
                    max += i - l;
                    min = Math.min(min, i - l);
                    l = i;
                }
            }

            p = c;
            temp = temp.next;
            i++;
        }

        if (max == 0) return new int[]{-1, -1};
        return new int[]{min, max};
    }
}