class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int area = width * height;
            maxWater = Math.max(maxWater, area);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
