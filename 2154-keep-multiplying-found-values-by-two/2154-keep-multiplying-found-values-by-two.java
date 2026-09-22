class Solution {
    public int findFinalValue(int[] nums, int original) {

        boolean[] present = new boolean[10];

        for (int num : nums) {
            for (int i = 0; i < 10; i++) {
                if (num == original * (1 << i)) {
                    present[i] = true;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!present[i]) {
                return original * (1 << i);
            }
        }

        return original * (1 << 10);
    }
}