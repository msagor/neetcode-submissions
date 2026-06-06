class Solution {
    public int[] productExceptSelf(int[] nums) {

        //make two arrays of size nums.length
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        //compute all prefix
        //for example nums=[1,2,3,4]
        //would produce prefix=[1,2,6,24]
        for(int i=0; i< nums.length; i++){
            if(i==0){
                //there is nothing left of the first index so we multiply with 1
                prefix[i] = 1*nums[i];
            }else{
                prefix[i] = prefix[i-1]*nums[i];
            }
        }

        //compute all postfix
        //for example nums=[1,2,3,4]
        //would produce postfix=[24,24,12,4]
        for(int j=nums.length-1; j>=0; j--){
            if(j==nums.length-1){
                //there is nothing right of the last index so we multiply with 1
                postfix[j] = nums[j]*1;
            }else{
                postfix[j] = postfix[j+1]*nums[j];
            }
        }

        /*
        // print prefix array
        for(int i=0; i<prefix.length; i++){
            System.out.println(prefix[i] + " ");
        }
        System.out.println("\n");
        // print postfix array
        for(int i=0; i<postfix.length; i++){
            System.out.println(postfix[i] + " ");
        }
        */

        //create resultant array
        int[] res = new int[nums.length];

        //populate resultant array
        for(int k=0; k< nums.length; k++){
            if(k==0){
                //there is nothing left of the first index so we multiply with 1
                res[k] = 1*postfix[k+1];
            }else if(k==nums.length-1){
                //there is nothing right of the last index so we multiply with 1
                res[k] = prefix[k-1]*1;
            }else{
                //multiple previous prefix with next postfix
                res[k] = prefix[k-1]*postfix[k+1];
            }
        }
        return res;

    }
}  
