class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> r = new ArrayList<>();
        int n = mountain.length;
        for (int i = 1; i < n - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) r.add(i);
        }
        return r;
    }
}