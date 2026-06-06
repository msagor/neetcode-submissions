class Solution {
    public int[] productExceptSelf(int[] nums) {
        //check submission-3 for descriptive version
        //make two arrays of size nums.length
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        //compute all prefix
        //for example nums=[1,2,3,4]
        //would produce prefix=[1,2,6,24]
        for(int i=0; i< nums.length; i++){
            prefix[i] = (i==0?1:prefix[i-1])*nums[i];
        }

        //compute all postfix
        //for example nums=[1,2,3,4]
        //would produce postfix=[24,24,12,4]
        for(int j=nums.length-1; j>=0; j--){
            postfix[j] = (j==nums.length-1?1:postfix[j+1])*nums[j];
        }

        //create resultant array
        int[] res = new int[nums.length];

        //populate resultant array
        for(int k=0; k< nums.length; k++){
            res[k] = (k==0?1:prefix[k-1]) * (k==nums.length-1?1:postfix[k+1]);
        }
        return res;

    }
}  
