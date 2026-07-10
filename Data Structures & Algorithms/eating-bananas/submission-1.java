class Solution {

    //global res variable
    int res = Integer.MAX_VALUE;

    public int minEatingSpeed(int[] piles, int h) {
        
        //we need to find k, the rate of eating bananas
        //k can be 1 at least,
        //k can also be the maximum bananas in a pile
        //so we are oing to try all k's between [1, max banana pile]

        int k_min = 1;
        int k_max = -1;
        for(int p: piles){
            if(p>k_max){
                k_max=p;
            }
        }

        //so now think of an array K = [k_min, ......, k_max]
        //we are going to use binary search on array K and test each candidate as solution

        int left = k_min;
        int right = k_max;

        binarySearch(left, right, piles, h, 0);
        return res;
    }

    public void binarySearch(int left, int right, int[] piles, int h, int iteration){

        //for debugging
        System.out.println("iteration - " + iteration);

        //break condition
        if(left>right){
            return;
        }

        //get the middle value of K
        int mid = left + (right - left) / 2;

        //eat all bananas from the piles as a group of mid,
        //and count how many hours needed.
        int h_needed = 0;
        for(int p: piles){
            //when we have remainder that counts as 1
            h_needed = h_needed + (p/mid) + (p%mid>0?1:0);
        }

        //decide which way the next iteration of binary search will go
        if(h_needed==h){
            //this rate can be a possible result so we store it
            res = Math.min(res, mid);

            //but we keep searching to left subArray to find better rate
            right = mid -1;

        }else if(h_needed < h){
            //this rate can be a possible result so we store it
            res = Math.min(res, mid);

            //but we keep searching to left subArray to find better rate
            right = mid -1;
        }else{
            //the sum went over h so our rate is too slow so need to increase rate
            //we keep searching to right subArray to find better result
            left = mid+1;
        }

        iteration++;
        binarySearch(left, right, piles, h, iteration);
    }
}
