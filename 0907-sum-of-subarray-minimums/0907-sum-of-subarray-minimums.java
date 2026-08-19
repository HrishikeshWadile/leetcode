class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long sum = 0;
        long MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            int curr = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > curr) {

                int mid = stack.pop();

                int left = stack.isEmpty()
                        ? mid + 1
                        : mid - stack.peek();

                int right = i - mid;

                sum = (sum + (long) arr[mid] * left * right) % MOD;
            }

            stack.push(i);
        }

        return (int) sum;
    }
}
