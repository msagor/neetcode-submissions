class Solution {
    public int maxProfit(int[] prices) {

        int profit = Integer.MIN_VALUE;

        int minBuyValue = Integer.MAX_VALUE;

        for(int i=0; i< prices.length; i++){
            int todays_price = prices[i];
            if(i==0){
                //first time in the market so this could be a possible buy value
                minBuyValue = todays_price;
            }else{
                //not the first time in the market
                //we can sell only if profit will be higher than what it is now
                if((todays_price>minBuyValue) && (todays_price-minBuyValue>profit)){
                    //good time to sell
                    profit = todays_price-minBuyValue;
                    System.out.println("current profit is: " + profit);
                }else{
                    //need to update buy value only if todays buy price will be cheaper
                    minBuyValue = Math.min(minBuyValue, todays_price);
                }

            }
        }

        return (profit==Integer.MIN_VALUE?0:profit);
        
    }
}
