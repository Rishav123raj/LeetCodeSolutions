class Solution {
    public int[] queryResults(int limit, int[][] queries) {
         HashMap<Integer, Integer> ballColors = new HashMap<>();
        // Map to count occurrences of each color
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            // If the ball already has a color, update the colorCount for the old color
            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }
            
            // Assign the new color to the ball
            ballColors.put(ball, color);
            
            // Update the colorCount for the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            
            // The number of distinct colors is the size of the colorCount map
            result[i] = colorCount.size();
        }
        
        return result;
    }
}