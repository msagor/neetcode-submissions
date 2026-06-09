class Solution {
    public int maxProfit(int[] prices) {

        //assume the profit is the lowest possible
        int profit = Integer.MIN_VALUE;

        //assume the buy value is the highest possible
        int minBuyValue = Integer.MAX_VALUE;

        //now we converted this into an optimization problem
        //we need to decrease the buy value and increase the profit

        for(int i=0; i< prices.length; i++){
            int todays_price = prices[i];
            if(i==0){
                //first time in the market so this could be a possible buy value
                minBuyValue = todays_price;
            }else{
                //not the first time in the market
                //we can sell only if todays price is higher than minBuyValue
                //and, profit will be higher than what it is now.
                if((todays_price>minBuyValue) && (todays_price-minBuyValue>profit)){
                    //good time to sell
                    profit = todays_price-minBuyValue;
                }else{
                    //selling wont make more profit, so thats out of the question.
                    //now, need to check if its a good day to buy.
                    //need to update buy value only if todays buy price will be cheaper
                    minBuyValue = Math.min(minBuyValue, todays_price);
                }

            }
        }

        //there could be case where we make no profit
        //for example, if the array is i descending order arr = [10, 7, 5, 3, 2],
        //in such case we will never make profit
        //profit can never be negative.
        return (profit==Integer.MIN_VALUE?0:profit);
        
    }
}
