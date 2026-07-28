
//implemented myself
class Solution {
    public int mySqrt(int x) {
        
        return binarySearch(x, 0, x);
    }

    public int binarySearch(int x, int start, int end){
        
        //i was returning start but chatgpt fixed it
        if(start>end){
            return end; 
        }

        int mid = start + (end - start)/2;

        //also was missing the cast to long, without this it doesnt work
        if((long)mid*mid==x){
            return mid;
        }

        if(x<(long)mid*mid){
            //need to search left subarray
            return binarySearch(x, start, mid-1);
        }else{
            //need to search right subarray
             return binarySearch(x, mid+1, end);
        }    
    }
}