class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();

        StringBuilder sb = new StringBuilder();

        int count = 0;

        // Repeat a until its length is at least b's length
        while (sb.length() < m) {
            sb.append(a);
            count++;
        }

        // Check current number of repetitions
        if (sb.indexOf(b) != -1) {
            return count;
        }

        // One extra repetition may be required
        sb.append(a);
        count++;

        if (sb.indexOf(b) != -1) {
            return count;
        }

        return -1;
    }
}
