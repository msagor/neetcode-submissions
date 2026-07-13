class Solution {
    //watched the video solution then implemented myself
    //i was very close, i was missing the nums1Pointer >=0 condition
    //watch the video again if you need to refresh memory
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