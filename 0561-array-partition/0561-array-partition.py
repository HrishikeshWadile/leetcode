class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        max_val = nums[0]
        min_val = nums[0]
        n = len(nums)

        for i in range(1, n):
            if max_val < nums[i]:
                max_val = nums[i]

            if min_val > nums[i]:
                min_val = nums[i]

        l = max_val - min_val + 1
        c = [0] * l

        for i in range(n):
            c[nums[i] - min_val] += 1

        sum = 0
        s = False

        for k in range(l):
            if c[k] != 0:
                a = c[k]

                if s:
                    a -= 1

                sum += ((a + 1) // 2) * (k + min_val)

                s = a % 2 == 1

        return sum