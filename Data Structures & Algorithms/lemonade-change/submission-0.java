class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int b: bills){
            if(b==5){
                five++;
            }else if(b==10){
                ten++;
                
                if(five==0){
                    return false;
                }

                five--;
                
            }else if(b==20){
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five = five-3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}