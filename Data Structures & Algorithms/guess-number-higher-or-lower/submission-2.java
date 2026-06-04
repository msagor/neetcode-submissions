/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return binary_search(1, n);
    }

    public int binary_search(int sIdx, int eIdx){

        int middle = sIdx + (eIdx - sIdx) / 2;

        int g_res = guess(middle);

        if(g_res==0){
            return middle;
        }else if(g_res==-1){
            return binary_search(sIdx, middle);
        }else if(g_res==1){
            return binary_search(middle+1, eIdx);
        }

        return -1000;
    }
}