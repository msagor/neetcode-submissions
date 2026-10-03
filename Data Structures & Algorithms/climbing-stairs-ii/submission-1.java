/*
//the idea is to continue to compute the min for each step, and reach the end.
//at the end, return the last slot in the dp array.
//below is my code that does not work

costs:  0    1    2    3    4
dp:     0    2    5    9   13

return dp[4]: 13

Iteration	i	dp[0]	dp[1]	dp[2]	dp[3]	dp[4]
      	    -	  0	     ∞	     ∞ 	     ∞	     ∞
   1	    0	  0 	 2	     6	     12	     ∞
   2	    1	  0	     2	     5	     9	     15
   3	    2	  0 	 2	     5	     9	     13
   4	    3	  0	     2	     5	     9	     13


*/

//solution from chatgpt

class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        // Starting position
        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            // one step
            if (i + 1 <= n) {
                dp[i + 1] = Math.min(
                    dp[i + 1],
                    dp[i] + costs[i] + 1 * 1
                );
            }

            // two steps
            if (i + 2 <= n) {
                dp[i + 2] = Math.min(
                    dp[i + 2],
                    dp[i] + costs[i + 1] + 2 * 2
                );
            }

            // three steps
            if (i + 3 <= n) {
                dp[i + 3] = Math.min(
                    dp[i + 3],
                    dp[i] + costs[i + 2] + 3 * 3
                );
            }
        }

        return dp[n];
    }
}

/*

//my implementation that does not work.
//but my on paper thinking was correct, i just couldnt implement it.
//i was trying a greedy approach - to pick the smallest cost at every three steps.
//this does not work because picking the local min cost doesnt guarantee overall minimum cost.
//below code doesnt work.
class Solution {
    public int climbStairs(int n, int[] costs) {

        //edge case
        if(costs.length==1){
            return 0 + costs[0] + (1*1);
        }
        
        int[] dp = new int[costs.length+1];
        dp[dp.length-1] = Integer.MAX_VALUE;

        int i=0;
        while(i<costs.length-1){
            
            int local_min = Integer.MAX_VALUE;
            int nextJumpIndex = -1;

            //one
            if(i+1<costs.length){

                
                //get cost after making one jump
                int jumpCost_1 = i==0?0:costs[i-1] + costs[i+1-1] + (1*1);

                //before replacing dp values, check if its the last step
                //we only keep the smallest value for dp[length-1]
                if(i+1==costs.length){
                    dp[i+1] = Math.min(dp[i+1], jumpCost_1);
                }else{
                    dp[i+1] = jumpCost_1;
                }
                


                //get the next jump index
                if(jumpCost_1<local_min){
                    local_min = jumpCost_1;
                    nextJumpIndex = i+1;
                }
            }

            //two
            if(i+2<costs.length){

                //get cost after making two jumps
                int jumpCost_2 = i==0?0:costs[i-1] + costs[i+2-1] + (2*2);

                //before replacing dp values, check if its the last step
                //we only keep the smallest value for dp[length-1]
                if(i+2==costs.length){
                    dp[i+2] = Math.min(dp[i+2], jumpCost_2);
                }else{
                    dp[i+2] = jumpCost_2;
                }
                

                //get the next jump index
                if(jumpCost_2<local_min){
                    local_min = jumpCost_2;
                    nextJumpIndex = i+2;
                }
            }

            //three
            if(i+3<costs.length){

                //get cost after making three jumps
                int jumpCost_3 = i==0?0:costs[i-1] + costs[i+3-1] + (3*3); 

                //before replacing dp values, check if its the last step
                //we only keep the smallest value for dp[length-1]
                if(i+3==costs.length){
                    dp[i+3] = Math.min(dp[i+3], jumpCost_3);
                }else{
                    dp[i+3] = jumpCost_3;
                }

                //get the next jump index
                if(jumpCost_3<local_min){
                    local_min = jumpCost_3;
                    nextJumpIndex = i+3;
                }
            }

            //coming here means we have made one jump,
            //whether its one, teo or three steps.
            //need to increment the idex for next jump
            i = nextJumpIndex;

        }

        return dp[dp.length-2];

    }
}

*/
