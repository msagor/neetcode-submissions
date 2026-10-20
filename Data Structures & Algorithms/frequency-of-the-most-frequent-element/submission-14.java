//implemneted myself but chatgpt fixed //here

class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0;
        int r = 0;

        int maxFreq = 0;

        while (l < nums.length && r < nums.length) {

            if (l == r) {
                maxFreq = Math.max(maxFreq, 1); //here
                r++;
            } else {
                int[] ret = getCost(nums, l, r);

                System.out.println(" l - " + l + " r - " + r + " count - " + ret[0] + " cost - " + ret[1]);

                if (ret[1] <= k) {

                    maxFreq = Math.max(maxFreq, ret[0]);

                    r++;

                } else {

                    l++;
                }
            }
        }

        return maxFreq;
    }

    // sIdx = startIndex
    // tIdx = targetIndex
    // return index 0 = number of elements made similar
    // return index 1 = total cost
    public int[] getCost(int[] nums, int sIdx, int tIdx) {

        long total = 0; //here

        for (int i = sIdx; i <= tIdx; i++) {
            total += nums[i];
        }

        long maxTotal = (long) nums[tIdx] * (tIdx + 1 - sIdx); //here

        long cost = maxTotal - total;

        //here: cost fits int for normal LeetCode constraints
        int[] res = new int[] {
            tIdx + 1 - sIdx,
            (int) cost
        };

        return res;
    }
}
