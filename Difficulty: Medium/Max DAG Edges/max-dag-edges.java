import java.util.*;

class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int[] indeg = new int[V];
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indeg[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indeg[i] == 0) q.add(i);

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int nxt : adj.get(node)) {
                indeg[nxt]--;
                if (indeg[nxt] == 0) q.add(nxt);
            }
        }

        boolean[][] connected = new boolean[V][V];
        for (int[] e : edges) {
            connected[e[0]][e[1]] = true;
        }

        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int u = topo.get(i);
                int v = topo.get(j);
                if (!connected[u][v]) count++;
            }
        }

        return count;
    }
}
