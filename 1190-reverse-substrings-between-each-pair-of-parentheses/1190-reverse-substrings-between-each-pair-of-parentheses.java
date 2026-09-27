class Solution {
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                st.push(i);
                arr[i] = '-';
            }

            else if (arr[i] == ')') {
                int left = st.pop();

                arr[i] = '-';

                int l = left + 1;
                int r = i - 1;

                while (l < r) {
                    char temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;

                    l++;
                    r--;
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char c : arr) {
            if (c != '-') {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}