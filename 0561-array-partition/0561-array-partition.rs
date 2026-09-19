impl Solution {
    pub fn array_pair_sum(nums: Vec<i32>) -> i32 {
        let mut max_val = nums[0];
        let mut min_val = nums[0];

        for i in 1..nums.len() {
            if max_val < nums[i] {
                max_val = nums[i];
            }

            if min_val > nums[i] {
                min_val = nums[i];
            }
        }

        let l = (max_val - min_val + 1) as usize;
        let mut c = vec![0; l];

        for &x in &nums {
            c[(x - min_val) as usize] += 1;
        }

        let mut sum = 0;
        let mut s = false;

        for k in 0..l {
            if c[k] != 0 {
                let mut a = c[k];

                if s {
                    a -= 1;
                }

                sum += ((a + 1) / 2) * (k as i32 + min_val);

                s = a % 2 == 1;
            }
        }

        sum
    }
}