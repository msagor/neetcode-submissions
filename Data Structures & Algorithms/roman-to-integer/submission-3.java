class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();

        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);


        int res = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);

            if(c=='I'){
                //check for IV and IX
                if((i+1<s.length()) && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                    if(s.charAt(i+1)=='V'){
                        //treat at IV
                        res = res + map.get("IV");
                    }else if(s.charAt(i+1)=='X'){
                        //treat at IX
                        res = res + map.get("IX");
                    }

                    //extra increment for pairs
                    i = i+1;
                }else{
                    //this is standalone I
                    res = res + map.get("I");
                }

            }else if(c=='X'){
                //check for XL and XC
                if((i+1<s.length()) && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                    if(s.charAt(i+1)=='L'){
                        //treat at XL
                        res = res + map.get("XL");
                    }else if(s.charAt(i+1)=='C'){
                        //treat at XC
                        res = res + map.get("XC");
                    }

                    //extra increment for pairs
                    i = i+1;
                }else{
                    //this is standalone X
                    res = res + map.get("X");  
                }
            }else if(c=='C'){
                //check for CD and CM
                if((i+1<s.length()) && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                    if(s.charAt(i+1)=='D'){
                        //treat at CD
                        res = res + map.get("CD");
                    }else if(s.charAt(i+1)=='M'){
                        //treat at CM
                        res = res + map.get("CM");
                    }

                    //extra increment for pairs
                    i = i+1;
                }else{
                    //this is standalone C
                    res = res + map.get("C");
                    
                }
            }else{
                //for standalone V,L,D,M
                res = res + map.get(c + "");
            }

            //regular increment for next iteration
            i = i+1;
        }

        return res;
        
    }
}