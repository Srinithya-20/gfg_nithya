class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int a = 0, b = n - 1;

        while (a < b) {
            if (mat[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        int c = a;

        for (int i = 0; i < n; i++) {
            if (i != c) {
                if (mat[c][i] == 1 || mat[i][c] == 0) {
                    return -1;
                }
            }
        }

        return c;
    }
}
