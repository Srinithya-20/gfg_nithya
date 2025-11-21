class Solution {

    static class Pair {
        int node;
        long dist;
        Pair(int n, long d) { node = n; dist = d; }
    }

    long[] dijkstra(int V, int src, ArrayList<ArrayList<int[]>> adj) {
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node;

            if (p.dist != dist[u]) continue;

            for (int[] ed : adj.get(u)) {
                int v = ed[0];
                int w = ed[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w1 = e[2];
            adj.get(u).add(new int[]{v, w1});
            adj.get(v).add(new int[]{u, w1});
        }

        long[] distA = dijkstra(V, a, adj);
        long[] distB = dijkstra(V, b, adj);

        long ans = distA[b];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            long curved = e[3];

            if (distA[u] != Long.MAX_VALUE && distB[v] != Long.MAX_VALUE)
                ans = Math.min(ans, distA[u] + curved + distB[v]);

            if (distA[v] != Long.MAX_VALUE && distB[u] != Long.MAX_VALUE)
                ans = Math.min(ans, distA[v] + curved + distB[u]);
        }

        return (ans == Long.MAX_VALUE ? -1 : (int) ans);
    }
}

