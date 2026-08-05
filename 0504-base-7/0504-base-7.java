class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }

        if (flag) {
            sb.insert(0, "-");
        }

        return sb.toString();
    }
}