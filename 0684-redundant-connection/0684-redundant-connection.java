class Solution {

    int[] parent;
    int[] size;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            // Already connected → this edge creates a cycle
            if (rootU == rootV) {
                return edge;
            }

            union(rootU, rootV);
        }

        return new int[0];
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {

        if (size[a] < size[b]) {
            parent[a] = b;
            size[b] += size[a];
        } else {
            parent[b] = a;
            size[a] += size[b];
        }
    }
}