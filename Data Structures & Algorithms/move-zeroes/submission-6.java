class Solution {
    //implemented myself using queue
    public void moveZeroes_mysolution(int[] nums) {
        Queue<Integer> zeroIndex = new LinkedList<>();

        for(int i=0; i< nums.length; i++){
            int n = nums[i];

            if(n==0){
                zeroIndex.add(i);
            }else{
                if(!zeroIndex.isEmpty()){
                    int z_idx = zeroIndex.poll();
                    nums[z_idx] = n;
                    nums[i] = 0;
                    zeroIndex.add(i);
                }
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        } 
    }
    
}