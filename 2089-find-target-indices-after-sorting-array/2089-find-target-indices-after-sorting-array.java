class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        int lessThanTarget = 0;
        int moreThanTarget = 0;
        
        for (int num : nums) {
            if (num < target) {
                lessThanTarget++;
            }
            else if (num > target) {
                moreThanTarget++;
            }
        }

        List<Integer> indexes = new ArrayList<>();

        for (int index = lessThanTarget; index < nums.length - moreThanTarget; index++) {
            indexes.add(index);
        }

        return indexes;
    }
}
