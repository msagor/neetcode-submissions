class Solution {

    public void sortColors_(int[] nums) {
        //watched solution video then implemented myself
        //notice the edge case handing for swap between 2 and 0
        //there are only three possibilities 0, 1, 2
        //we will use two pointers to sort 0s and 2s, 1 will sort itself
        //one edge case - when swapping 2 with 0, make sure to place the 0 at its index, not at i

        int left = 0;
        int right = nums.length-1;

        //need to maybe shift right pointer to a position when its not 2
        //for example what if the given array is [2, 1, 0, 2]
        //left is at 0, right is at end of array
        //at index i=0, we will attmept to swap 2 with 2 which is not productive
        while(nums[right]!=2){
            right--;
        }
        
        int i=0;
        while(i<nums.length && i<=right){

            //get the candidate value
            int val = nums[i];

            //check if 0
            if(val==0){
                //swap between nums[left] and val
                int tempLeft = nums[left];
                nums[left] = val;
                nums[i] = tempLeft;

                //increment left pointer
                left++;

            }else if (val==2){
                //swap between nums[right] and val
                int tempRight = nums[right];
                nums[right] = val;

                //decrease right pointet
                right--;

                //check if tempRight is not 0
                if(tempRight==0){
                    //we need to place 0 at the left index
                    int tempLeft = nums[left];
                    nums[left] = tempRight;
                    nums[i] = tempLeft;
                    left++;
                }else{
                    //regular swap
                    nums[i] = tempRight;
                }
            }

            //increment i
            i++;
        }

    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;          // safe to move forward
            } 
            else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;      // DO NOT increment i here
            } 
            else { // nums[i] == 1
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}