public class Solution {

    public int[][] kClosest(int[][] points, int K) {

        // Create a Comparator object to define how two int[] arrays are compared.
        Comparator cmp = new Comparator<int[]>() {

            // This method is called by PriorityQueue whenever it needs to compare two elements.
            // a and b are two points stored in the heap.
            @Override
            public int compare(int[] a, int[] b) {

                // Each array is stored as:
                // a[0] = distance
                // a[1] = x coordinate
                // a[2] = y coordinate
                //
                // Compare based only on distance.
                // Smaller distance gets higher priority (min heap).
                return Integer.compare(a[0], b[0]);
            }
        };

        // Create a min heap that stores int[] arrays.
        // The heap will decide priority using the Comparator below.
        // The element with the smallest distance will always be at the top.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(cmp);


        // Loop through every point in the input array.
        for (int[] point : points) {

            // Calculate squared Euclidean distance from origin:
            // distance = x^2 + y^2
            //
            // We don't need sqrt because comparing:
            // 3^2 + 4^2 = 25
            // sqrt(25) = 5
            // gives the same ordering.
            int dist = point[0] * point[0] + point[1] * point[1];


            // Insert the point into the heap.
            //
            // Store three values:
            // index 0 -> distance
            // index 1 -> x coordinate
            // index 2 -> y coordinate
            //
            // Example:
            // point = {3,4}
            // dist = 25
            // store {25,3,4}
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }


        // Create output array to store K closest points.
        //
        // It has K rows and each row has 2 values:
        // [x, y]
        int[][] result = new int[K][2];


        // Remove the K smallest-distance points from the heap.
        for (int i = 0; i < K; ++i) {

            // poll() removes and returns the element with the smallest distance.
            //
            // Example:
            // {8,2,2} will be removed before {25,3,4}
            int[] point = minHeap.poll();


            // Convert back to the original format.
            //
            // Heap element:
            // {distance, x, y}
            //
            // Result needs:
            // {x, y}
            //
            // Ignore point[0] because it is only used for sorting.
            result[i] = new int[]{point[1], point[2]};
        }


        // Return the K closest points.
        return result;
    }
}