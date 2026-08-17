//lazy implemented myself 
//https://leetcode.com/problems/compare-version-numbers/
class Solution {
    public int compareVersion(String version1, String version2) {

        List<String> v1 = new ArrayList<>();
        List<String> v2 = new ArrayList<>();

        int i=0;
        String token1 = "";
        while(i<=version1.length()-1){

            if(version1.charAt(i)=='.'){
                v1.add(token1);
                token1 = "";
            }else if(i==version1.length()-1){
                token1 = token1 + version1.charAt(i);
                v1.add(token1);
                token1 = "";
            }else{
                token1 = token1 + version1.charAt(i);
            }
            i++;
        }
        
        int j=0;
        String token2 = "";
        while(j<=version2.length()-1){
            if(version2.charAt(j)=='.'){
                v2.add(token2);
                token2 = "";
            }else if(j==version2.length()-1){
                token2 = token2 + version2.charAt(j);
                v2.add(token2);
                token2 = "";
            }else{
                token2 = token2 + version2.charAt(j);
            }
            j++;
        }

        int ii = 0;
        int jj = 0;
        while(ii<v1.size() || jj<v2.size()){
            String t1, t2 = "";
            if(ii>=v1.size()){
                t1 = "0";
            }else{
                t1 = v1.get(ii);
            }

            if(jj>=v2.size()){
                t2 = "0";
            }else{
                t2 = v2.get(jj);
            }

            int t1_int = (int) Integer.parseInt(t1);
            int t2_int = (int) Integer.parseInt(t2);

            System.out.println("t1_int=" + t1_int + " t2_int=" + t2_int);

            if(t1_int<t2_int){
                return -1;
            }else if(t1_int>t2_int){
                return 1;
            }

            ii++;
            jj++;
        }

        return 0;
    }
}
