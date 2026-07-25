class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        mainTank += Math.min((mainTank - 1) / 4, additionalTank);
        return mainTank * 10;
    }
}