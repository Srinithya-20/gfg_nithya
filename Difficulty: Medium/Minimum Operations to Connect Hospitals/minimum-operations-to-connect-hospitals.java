class Solution {
    public int minConnect(int V, int[][] edges) {
        int E = edges.length;
        if (E < V - 1) return -1;

        DSU dsu = new DSU(V);

        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        int components = 0;
        for (int i = 0; i < V; i++) {
            if (dsu.find(i) == i) components++;
        }

        return components - 1;
    }
}

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pb] < rank[pa]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}
