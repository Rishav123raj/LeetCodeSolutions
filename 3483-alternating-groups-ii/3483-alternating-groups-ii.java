class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        
        // Precompute the difference array
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = colors[i] == colors[(i + 1) % n] ? 0 : 1;
        }
        
        // Use a sliding window of size k-1 on the diff array
        int windowSum = 0;
        for (int i = 0; i < k - 1; i++) {
            windowSum += diff[i];
        }
        
        for (int i = 0; i < n; i++) {
            // If the window sum is k-1, it means all transitions within the window are alternating
            if (windowSum == k - 1) {
                count++;
            }
            // Slide the window
            windowSum -= diff[i];
            windowSum += diff[(i + k - 1) % n];
        }
        
        return count;
    }
}