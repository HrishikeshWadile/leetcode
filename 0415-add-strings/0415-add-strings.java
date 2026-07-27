class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int s = 0, c = 0, n = 0, i = num1.length() - 1, j = num2.length() - 1; 
        while (i >= 0 && j >= 0) {
            n = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + c;
            s = n % 10;
            c = n / 10;
            sb.append(s);
            i--;
            j--;
        } while (i >= 0) {
            n = (num1.charAt(i) - '0') + c;
            s = n % 10;
            c = n / 10;
            sb.append(s);
            i--;
        } while (j >= 0) {
            n = (num2.charAt(j) - '0') + c;
            s = n % 10;
            c = n / 10;
            sb.append(s);
            j--;
        }
        if (c == 1) sb.append('1');
        return sb.reverse().toString();
    }
}