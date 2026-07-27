class Solution {
    public int thirdMax(int[] nums) {
        int distinct = 0, fm = 0, sm = 0, tm = 0;
        for (int i = 0; i < nums.length; i++) {
            if (distinct == 0) {
                fm = nums[i];
                distinct++;
            } else if (distinct == 1) {
                if (fm != nums[i]) {
                    sm = Math.min(nums[i], fm);
                    fm = Math.max(nums[i], fm);
                    distinct++;
                }
            } else if (distinct == 2) {
                if (nums[i] != fm && nums[i] != sm) {
                    if (nums[i] > fm) {
                        tm = sm;
                        sm = fm;
                        fm = nums[i];
                    } else if (nums[i] > sm) {
                        tm = sm;
                        sm = nums[i];
                    } else {
                        tm = nums[i];
                    }
                    distinct++;
                }
            } else {
                if (nums[i] != fm && nums[i] != sm && nums[i] != tm) {
                    if (nums[i] > fm) {
                        tm = sm;
                        sm = fm;
                        fm = nums[i];
                    } else if (nums[i] > sm) {
                        tm = sm;
                        sm = nums[i];
                    } else if (nums[i] > tm){
                        tm = nums[i];
                    }
                }
            }
        }
        return distinct > 2 ? tm : fm;
    }
}