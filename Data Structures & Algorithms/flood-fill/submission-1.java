class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // Get the original color of the starting cell
        int originalColor = image[sr][sc];

        // If the starting cell already has the target color,
        // we don't need to do anything
        if (originalColor == color) {
            return image;
        }

        // BFS uses a Queue
        Queue<int[]> queue = new LinkedList<>();

        // Add the starting position to the queue
        queue.offer(new int[]{sr, sc});

        // Change the color immediately so we don't visit it again
        image[sr][sc] = color;

        // Directions: up, down, left, right
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Continue BFS while there are cells to process
        while (!queue.isEmpty()) {

            // Remove the next cell from the queue
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            // Check all 4 neighboring cells
            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the neighbor is inside the grid
                if (newRow >= 0 &&
                    newRow < image.length &&
                    newCol >= 0 &&
                    newCol < image[0].length &&

                    // Only process cells with the original color
                    image[newRow][newCol] == originalColor) {

                    // Change color immediately to mark it as visited
                    image[newRow][newCol] = color;

                    // Add this new cell to the queue
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}