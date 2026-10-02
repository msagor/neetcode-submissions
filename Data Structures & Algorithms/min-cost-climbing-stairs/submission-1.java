//entirely done by myself
//i started with making the cost box
//
//
//
// cost     1 2 1 2 1 1 1 *
// min_cost 0 0 A B C D E F
// return F
//
// we can get A by getting the min of cost[0]+min_cost[0] VS cost[1]+min_cost[1]
//
//
//
//


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        if(cost.length==2){
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length+1];
        
        for(int i=2; i<=cost.length; i++){
            int prevIndex_1 = i-1;
            int prevIndex_2 = i-2;
            dp[i] = Math.min(
                    (cost[prevIndex_2]+dp[prevIndex_2]), 
                    (cost[prevIndex_1]+dp[prevIndex_1])
                );
        }

        return dp[dp.length-1];
    }
}
