class Solution {
    //watched the video solution then implemented myself
    //i was very close, i was missing the nums1Pointer >=0 condition
    //watch the video again if you need to refresh memory

    //Algorithm:
        //look at example #1, nums1 array has some empty values at the end.
        //so we need to populate them first and make our way towards the star of the array
        //so for example #1, nums1 = [10,20,20,40,0,0]. nums2 = [1,2]
            //at iteration #1 => we compare 40 vs 2, result in nums1 = [10,20,20,40,0,40]
            //at iteration #2 => we compare 20 vs 2, result is nums1 = [10,20,20,40,20,40]
            //at iteration #3 => we compare 20 vs 2, result is nums1 = [10,20,20,20,20,40]
            //at iteration #4 => we compare 10 vs 2, result is nums1 = [10,20,10,20,20,40]
            //at iteration #5 => we compare null vs 2, result is nums1 = [10,2,10,20,20,40]
            //at iteration #6 => we compare null vs 1, result is nums1 = [1,2,10,20,20,40]
        //more details at the bottom of this page
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //unique corner case
        if(m==0){
            for(int i=0; i<nums2.length; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        
        //this is the position of nums1 where we will be inserting values,
        //we will be populating the nums1 array from largest to smallest
        int insertIndex = nums1.length-1;

        //pointer that will traverse nums1, starts at mth place
        int nums1Pointer = m-1 ;

        //pointer that will traverse nums2, starts at nth place
        int nums2Pointer = n-1;

        //since num2 is guaranteed ot be smaller than nums1,
        //if we run out of nums2 elements, then we can exit the loop
        while(nums2Pointer >= 0){
            if(nums1Pointer >=0 && nums1[nums1Pointer] >= nums2[nums2Pointer]){
                //element in nums1 is larger
                nums1[insertIndex] = nums1[nums1Pointer];

                //decrease nums1Pointer
                nums1Pointer--;

                //decrease insertIndex for next iteration
                insertIndex--;
            }else{
                //element in nums2 is larger
                nums1[insertIndex] = nums2[nums2Pointer];

                //decrease nums2Pointer
                nums2Pointer--;

                //decrease insertIndex for next iteration
                insertIndex--;
            }
        }

        //coming here means we ran out of nums2 elements
        //that means rest of the nums1 is already sorted
    }
}



//assuming the given arrays is nums1 = [0,0,10,20,20,40]. nums2 = [1,2]
//in that case we could not do what we did above - populating from the end towards start.
//instead, we would have to populate from start to end
//so for that example - nums1 = [0,0,10,20,20,40]. nums2 = [1,2]
    //at iteration #1 => we would compare 10 vs 1, result in nums1 = [1,0,10,20,20,40]
    //at iteration #2 => we would compare 10 vs 2, result in nums1 = [1,2,10,20,20,40]
    //at iteration #3 => we would compare 10 vs null, result in nums1 = [1,2,10,20,20,40]
    //at iteration #4 => we would compare 20 vs null, result in nums1 = [1,2,10,20,20,40]
    //at iteration #5 => we would compare 20 vs null, result in nums1 = [1,2,10,20,20,40]
    //at iteration #6 => we would compare 40 vs null, result in nums1 = [1,2,10,20,20,40]
