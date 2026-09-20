class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int c = 0;
        boolean f = false;

        while (head != null) {
            if (set.contains(head.val)) {
                if (!f) {
                    c++;
                    f = true;
                }
            } else {
                f = false;
            }

            head = head.next;
        }

        return c;
    }
}