class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public void mergeSort(int[] nums){
        divide(nums, 0, nums.length-1);
    }

    public void divide(int[] nums, int start, int end){
        if(start>=end){
            return; //we are done
        }else{
            //find the middle of the array
            int middle = start + (end-start)/2;

            //send them down the divide path
            divide(nums, start, middle);
            divide(nums, middle+1, end);


            //conquer
            conquer(nums, start, middle, middle+1, end);
        }
    }

    public void conquer(int[] nums, int l1, int l2, int r1, int r2){

        //first get the size of the sibarrays
        int n1 = l2 - l1 + 1;
        int n2 = r2 - r1 + 1;

        //create two empty subarrays
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        //copy over data from main to temp array
        for(int idx=0; idx<n1; idx++){
            temp1[idx] = nums[l1+idx];
        }

        for(int idx=0; idx<n2; idx++){
            temp2[idx] = nums[r1+idx];
        }

        //now compare and sort the array
        //suppot two subarrays, temp1 = [1,5] and temp2 =[2,3]
        int i = 0;
        int j = 0;
        int k = l1;

        //we run the while loop until one of the temp arrays are done sorting
        while(i<n1 && j<n2){
            if(temp1[i]<temp2[j]){
                nums[k] = temp1[i];
                i++;
                k++;
            }else{
                nums[k] = temp2[j];
                j++;
                k++;
            }
        }

        //aftet this while loop is done, there could still be some values remainaing
        //for example, if we have temp1 = [1,5] and temp2 =[2,3]
        //during first iteration, we compare 1 vs 2 and pick 1
        //during second iteration, we compare 5 vs 2, and pick 2
        //during third iteration, we compare5 vs 3 and pick 3
        //during fourth iteration, we exit out of while loop coz j is now greater than n2
        //but what happened to 5? we did not sort it, 
        //so we need to copy the remaining values of temp1 at teh end of nums
        //only one of below while loops will execute
        while(i<n1){
            nums[k] = temp1[i];
            i++;
            k++;
        }

        while(j<n2){
            nums[k] = temp2[j];
            j++;
            k++;
        }

    }
}
