class Solution {

    int res = Integer.MAX_VALUE;

    public int shipWithinDays(int[] weights, int days) {
        //The minimum possible capacity is the maximum weight of any single package,
        //and the maximum possible capacity is the sum of all package weights.

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int w : weights) {
            max = Math.max(max, w);
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

        int daysNeeded = inCapacity(weights, mid);

        if (daysNeeded == days) {
            //Exact match. This capacity works, but there may be a smaller one.
            res = Math.min(res, mid);
            binarySearch(weights, start, mid - 1, days);

        } else if (daysNeeded > days) {
            //We need more days than allowed, so the capacity is too small.
            binarySearch(weights, mid + 1, end, days);

        } else {
            //We finished in fewer days than allowed.
            //This capacity is also valid, but we may be able to reduce it.
            res = Math.min(res, mid);
            binarySearch(weights, start, mid - 1, days);
        }
    }

    //Returns the number of days required to ship all packages
    //using the given ship capacity.
    //Packages must remain in order and cannot be split.
    public int inCapacity(int[] weights, int capacity) {

        int daysNeeded = 1;
        int currentLoad = 0;

        for (int w : weights) {

            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }

            currentLoad += w;
        }

        return daysNeeded;
    }
}