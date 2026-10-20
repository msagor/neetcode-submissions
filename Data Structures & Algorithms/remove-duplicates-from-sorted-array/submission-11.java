class Solution {
    public int removeDuplicates(int[] nums) {

        int res = 0;

        int prev = nums[0];
        int idx = 1;

        for(int i=1; i< nums.length; i++){

            if(nums[i]!=prev){
                nums[idx] = nums[i];
                idx++;
                res++;
            }else{
                continue;
            }

            prev = nums[i];
        }

        return res+1;
    }
}


/*

//first, we start from index 1, coz index 0 is used for prev

    int prev = nums[0];
    int idx = 1; // write pointer.

//second, if a value at index i is different from its prev, write 

    int prev = nums[0];
    int idx = 1;

    for(int i=1; i< nums.length; i++){
        if(nums[i]!=prev){
            nums[idx] = nums[i];
            idx++;
        }
    }

//third, if a value at index i is same as prev, we ocntinue
    //note that, even though i incrementing, 
    //idx is not incrementing coz it only increments when nums[i] does not match with prev


//fourth, update prev to nums[i] is every iteration
    //also add res


example:    1 2 2 2 3 3 4
i at 1:     1 2 2 2 3 3 4
i at 2:     1 2 * 2 3 3 4
i at 3:     1 2 * 2 3 3 4
i at 4:     1 2 3 * 3 3 4
i at 5:     1 2 3 * 3 3 4
i at 6:     1 2 3 4 3 3 4
  
*/
