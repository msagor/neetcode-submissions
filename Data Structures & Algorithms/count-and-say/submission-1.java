
//leetcode - https://leetcode.com/problems/count-and-say/
class Solution {
    public String countAndSay(int n) {

        String str = "1";

        //You need to apply RLE() only (n-1) times to reach term n.
        for(int i=1; i<n; i++){
            System.out.println("str before - " + str);
            str = RLE(str);
            System.out.println("str after - " + str);
        }

        return str;
    }


    public String RLE(String str){

        String res_str = "";

        String temp_str = "";
        int temp_count = 0;
            
        int i=0;
        while(i<str.length()){
            char c = str.charAt(i);

            if(temp_str.isEmpty()){
                temp_str = String.valueOf(c);
                temp_count++;
            }else if(c==temp_str.charAt(temp_str.length()-1)){
                temp_count++;
            }else{
                //we encountered a new char
                //add the previous char and its count to the res_str
                res_str += String.valueOf(temp_count) + temp_str;

                //reset temp variables
                temp_str = "";
                temp_count = 0;

                //now we put the new char in the temp variables
                temp_str = String.valueOf(c);
                temp_count++;
            }

            i++;
        }

        res_str += String.valueOf(temp_count) + temp_str;

        return res_str;
    }
}
