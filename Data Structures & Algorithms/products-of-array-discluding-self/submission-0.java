
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        int j = nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(i==0){
               prefix[i] = 1; 
            }
            else{
                prefix[i] = prefix[i-1]*nums[i-1];
            }

            if(j==nums.length-1){
                postfix[j] = 1;
            }else{
                postfix[j] = postfix[j+1]*nums[j+1];
            }
            j--;
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
        }*/

        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            res[i] = prefix[i]*postfix[i];
        }

        return res;
    }
}  
