class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();

        HashSet<String> d = new HashSet<>();

        for (int i = 0; i < n; i++) {
            d.add(paths.get(i).get(1));
        }

        for (int i = 0; i < n; i++) {
            d.remove(paths.get(i).get(0));
        }

        return d.iterator().next();
    }
}