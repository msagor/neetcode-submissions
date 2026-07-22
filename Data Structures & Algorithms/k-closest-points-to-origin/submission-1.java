public class Solution {
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            }
        );

        //PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];

            // Store: {distance, x, y}
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[K][2];

        for (int i = 0; i < K; ++i) {
            int[] point = minHeap.poll();

            // Extract only x and y
            result[i] = new int[]{point[1], point[2]};
        }

        return result;
    }
}