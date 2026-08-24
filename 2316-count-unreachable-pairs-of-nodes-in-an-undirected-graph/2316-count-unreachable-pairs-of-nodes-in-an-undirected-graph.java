class Solution {
    public long countPairs(int n, int[][] edges) {

        int k = 0;
        int m = edges.length;

        if (m == 0)
            return (long) n * (n - 1) / 2;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        long ans = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; i++) {

            if (vis[i])
                continue;

            int size = dfs(i, graph, vis);

            ans -= (long) size * (size - 1) / 2;
        }

        return ans;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] vis) {

        vis[node] = true;
        int size = 1;

        for (int next : graph.get(node)) {
            if (!vis[next])
                size += dfs(next, graph, vis);
        }

        return size;
    }
}