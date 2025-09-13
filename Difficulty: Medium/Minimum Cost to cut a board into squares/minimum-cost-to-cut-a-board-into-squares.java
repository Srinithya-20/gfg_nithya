import java.util.*;

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);
        reverse(x);
        reverse(y);
        
        int i = 0, j = 0;
        int horizontalSegments = 1, verticalSegments = 1;
        int totalCost = 0;
        
        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                totalCost += x[i] * horizontalSegments;
                verticalSegments++;
                i++;
            } else {
                totalCost += y[j] * verticalSegments;
                horizontalSegments++;
                j++;
            }
        }
        
        while (i < x.length) {
            totalCost += x[i] * horizontalSegments;
            verticalSegments++;
            i++;
        }
        
        while (j < y.length) {
            totalCost += y[j] * verticalSegments;
            horizontalSegments++;
            j++;
        }
        
        return totalCost;
    }
    
    private static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
