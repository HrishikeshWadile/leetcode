class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue; // no leading zero

            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue;

                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;

                    if (digits[k] % 2 != 0) continue; // must be even

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                    set.add(num);
                }
            }
        }

        int[] ans = new int[set.size()];
        int x = 0;

        for (int num : set) {
            ans[x++] = num;
        }

        Arrays.sort(ans);

        return ans;
    }
}