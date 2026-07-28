//I had multiple errors in my original solution. ChatGPT helped me identify and fix them,
//but this is my implementation.
class Solution {

    int res = Integer.MAX_VALUE;

    public int shipWithinDays(int[] weights, int days) {
        //The minimum possible capacity is the maximum weight of any single package,
        //and the maximum possible capacity is the sum of all package weights.
        //Initially, I incorrectly used the maximum package weight as the upper bound.

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int w : weights) {
            max = Math.max(w, max);
            sum += w;
        }

        binarySearch(weights, max, sum, days);

        return res;
    }

    public void binarySearch(int[] weights, int start, int end, int days) {

        if (start > end) {
            return;
        }

        int mid = start + (end - start) / 2;

        boolean r = inCapacity(weights, days, mid);

        if (r) {
            //The chosen capacity is too small, so we need to search for a larger capacity.
            binarySearch(weights, mid + 1, end, days);
        } else {
            //This capacity is valid (it ships all packages within the given number of days).
            //Record it as a possible answer and continue searching for a smaller valid capacity.
            res = Math.min(res, mid);
            binarySearch(weights, start, mid - 1, days);
        }

    }

    //Returns true if the chosen capacity is too small (requires more than 'days' days).
    //Returns false if the chosen capacity is valid (requires at most 'days' days).
    //
    //My original implementation was incorrect because I simply divided the total weight
    //by the capacity. That doesn't work since packages must be shipped in order and
    //cannot be split across days. We must simulate the loading process.
    public boolean inCapacity(int[] weights, int days, int capacity) {

        int daysNeeded = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }

            currentLoad += w;
        }

        return daysNeeded > days;
    }
}