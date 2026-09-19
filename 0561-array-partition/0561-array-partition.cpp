class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        int maxVal = nums[0], minVal = nums[0];
        int n = nums.size();

        for (int i = 1; i < n; i++) {
            if (maxVal < nums[i]) maxVal = nums[i];
            if (minVal > nums[i]) minVal = nums[i];
        }

        int l = maxVal - minVal + 1;
        vector<int> c(l, 0);

        for (int i = 0; i < n; i++) {
            c[nums[i] - minVal]++;
        }

        int sum = 0;
        bool s = false;

        for (int k = 0; k < l; k++) {
            if (c[k] != 0) {
                int a = c[k];

                if (s) a--;

                sum += ((a + 1) / 2) * (k + minVal);

                s = a % 2 == 1;
            }
        }

        return sum;
    }
};