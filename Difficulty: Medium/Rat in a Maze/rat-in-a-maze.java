import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return res;
        boolean[][] visited = new boolean[n][n];
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        backtrack(0, 0, maze, n, "", visited, res, di, dj, dir);
        Collections.sort(res);
        return res;
    }

    private void backtrack(int i, int j, int[][] maze, int n, String path,
                           boolean[][] visited, ArrayList<String> res,
                           int[] di, int[] dj, char[] dir) {
        if (i == n - 1 && j == n - 1) {
            res.add(path);
            return;
        }
        visited[i][j] = true;
        for (int idx = 0; idx < 4; idx++) {
            int nextI = i + di[idx];
            int nextJ = j + dj[idx];
            if (isSafe(nextI, nextJ, maze, n, visited)) {
                backtrack(nextI, nextJ, maze, n, path + dir[idx], visited, res, di, dj, dir);
            }
        }
        visited[i][j] = false;
    }

    private boolean isSafe(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}
