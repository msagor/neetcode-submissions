//solution from Solution
//sorting time complexity - O(nlogN)
//time complexity - O(nlogK)
//need to learn the quicksort solution


// note we use minheap so that when PQ overflows we can easily get rid of the largest value
// so if the problem is findKthSmallest we would use maxheap instead.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}