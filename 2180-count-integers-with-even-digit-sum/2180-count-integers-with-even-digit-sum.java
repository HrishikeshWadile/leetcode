class Solution {
    public int countEven(int num) {
        int s = num % 10 + (num / 10) % 10 + (num / 100) % 10 + (num / 1000) % 10;
        if (s % 2 == 1) {
            return (num - 1) / 2;
        }
        return num / 2;
    }
}