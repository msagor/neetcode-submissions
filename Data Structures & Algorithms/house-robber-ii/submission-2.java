
//did entirely myself
//must do House Robber 1 before this
//note that - you dont have to handle even and odd numbers of nums separately.
//also note the trick with dpIdx in robHouse()

class Solution {
    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }


        //dont rob last house
        int robFirstHouse = robHouse(nums, 0, nums.length-2);
        System.out.println("robFirstHouse - " + robFirstHouse);

        
        //rob last house
        int dontRobFirstHouse = robHouse(nums, 1, nums.length-1);
        System.out.println("dontRobFirstHouse - " + dontRobFirstHouse);

        return Math.max(robFirstHouse, dontRobFirstHouse);
    }

    //start and end are inclusive
    public int robHouse(int[] nums, int start, int end){

        System.out.println("start - " + start + " end - " + end);
        int[] dp = new int[end - start + 1];

        int dpIdx = 0;
        for(int i=start; i<=end; i++){
            if(i==start){
                dp[dpIdx] = nums[i];
            }else if(i==start+1){
                dp[dpIdx] = Math.max(nums[i], dp[dpIdx-1]);
            }else{
                dp[dpIdx] = Math.max(nums[i]+dp[dpIdx-2], dp[dpIdx-1]);
            }

            dpIdx++;
        }

        return dp[dpIdx-1];
    }
}
