class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        String s1, s2;
        for(int i=0; i< strs.length; i++){
            if(i==0){
                s1=strs[0];
                s2 = strs[i];
            }else{
                s1=res;
                s2 = strs[i];
                res = ""; //need to reset res since s1 has the value
            }

            // find longest prefix between s1 and s2
            for(int j=0; j< Math.min(s1.length(), s2.length()); j++){
                if(s1.charAt(j) == s2.charAt(j)){
                    res = res + s1.charAt(j);
                }else{
                    break; 
                }
            }
            System.out.println("iteration " + i + " s1 - " + s1 + " s2 - " + s2 + " res - " + res);
        }

        return res;
    }
}