class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] jewel = new boolean[52];

        for (char c : jewels.toCharArray()) {
            jewel[index(c)] = true;
        }

        int count = 0;

        for (char c : stones.toCharArray()) {
            if (jewel[index(c)]) {
                count++;
            }
        }

        return count;
    }

    int index(char c) {
        int r = c - 'A';

        if (r > 25) {
            r -= 6;
        }

        return r;
    }
}