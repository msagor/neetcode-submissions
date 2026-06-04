class Solution {
    public void moveZeroes(int[] nums) {
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
}