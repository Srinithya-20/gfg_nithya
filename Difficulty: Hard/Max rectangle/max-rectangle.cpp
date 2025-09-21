class Solution {
public:
    int getMaxArea(vector<int> &arr) {
        int n = arr.size();
        vector<int> next(n, n), prev(n, -1);
        stack<int> ss;

        
        for (int i = 0; i < n; i++) {
            while (!ss.empty() && arr[ss.top()] > arr[i]) {
                next[ss.top()] = i;
                ss.pop();
            }
            ss.push(i);
        }
        while (!ss.empty()) ss.pop();

       
        for (int i = n - 1; i >= 0; i--) {
            while (!ss.empty() && arr[ss.top()] > arr[i]) {
                prev[ss.top()] = i;
                ss.pop();
            }
            ss.push(i);
        }

        int ans = 0; 
        for (int i = 0; i < n; i++) {
            int width = next[i] - prev[i] - 1;
            int height = arr[i];
            ans = max(ans, width * height);
        }
        return ans; 
    }

    int maxArea(vector<vector<int>> &mat) {
        int n = mat.size();
        int m = mat[0].size();

        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) continue;
                mat[i][j] += mat[i - 1][j];
            }
        }

        int ans = 0; 
        for (int i = 0; i < n; i++) {
            ans = max(ans, getMaxArea(mat[i]));
        }

        return ans; 
    }
};
