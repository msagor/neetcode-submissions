
//dp solution below done with Amran 
class Solution {
    
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        backtrack(coins, 0, amount, 0, 0);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void backtrack(int[] coins, int idx, int amount, int total, int path) {
        
        // reached the target
        if (total == amount) {
            res = Math.min(res, path);
            return;
        }

        // exceeded the target
        if (total > amount) {
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            
            total += coins[i];

            //here: use i, not i + 1, because we can reuse the same coin
            backtrack(coins, i, amount, total, path + 1);

            total -= coins[i];
        }
    }   
}



/*

//badically ask hjow ay coins needed to make X dollar - 
    //ex - coins = [1,5,10], amount = 12
    //we need to try making every dollar from 1 to 12
    //to make 1 dollar -
        //coin 1 is available, so we need one coin of 1
    //to make 2 dollars - 
        //coin 2 is not available, so we need to use smaller coin to make 2
        //coin 1 is available, so we need two coins of 1
    //to make 3 dollars - 
        //coin 3 is not available, so we need to use smaller coin to make 3
        //coin 1 is available, so we need three coins of 1
    //to make 4 dollars - 
        //coin 4 is not available, so we need to use smaller coin to make 4
        //coin 1 is available, so we need four coins of 1
    //to make 5 dollars - 
        //coin 5 is available, so we need one coin of 5
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];

        for(int i=1; i<=amount; i++){
            dp[i] = amount+1;
            for(int coin: coins){
                if(coin<=i){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];

    }
}

*/