//do - Find Minimal Shoppers after this 
//https://www.hack2hire.com/question-bank/questions/coding-questions/688102f5f96758aa78e1d679/practice?questionId=688102fcf96758aa78e1d67a&collectionKey=hack2hire-50-picks

class Solution {
    public double averageWaitingTime(int[][] customers) {

        //first, we find the arrive and food served period for each customer
        int[] arrive = new int[customers.length];
        int[] served = new int[customers.length];

        int currTime = 0;

        int i=0;
        for(int[] cust: customers){

            //set arrival
            arrive[i] = cust[0];

            if(cust[0]>currTime){
                //this customer came when chef was not busy
                served[i] = cust[0] + cust[1];
                currTime = cust[0] + cust[1];
            }else{
                //customer came when chef was preparing someone elses meal,
                //currTime denotes to the time chef can start this customer meal
                served[i] = currTime + cust[1];
                currTime = currTime + cust[1];
            }

            i++;
        }

        //second, we find the delay for each customers
        int[] delays = new int[customers.length];

        i=0;
        for(int serve: served){
            delays[i] = served[i] - arrive[i];
            i++;
        }


        //third, we add up all delays and get the average
        double total_delays = 0.0;
        for(int delay: delays){
            total_delays += (double) delay;
        }

        return total_delays/delays.length;
    }
}