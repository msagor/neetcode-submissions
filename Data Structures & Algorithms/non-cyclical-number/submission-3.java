
//solution from Solution but the helper function re-written by me
//notice how i converted a char to int digit
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while (!visit.contains(n)) {
            visit.add(n);
            n = sumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    //function writtne by me
    private int sumOfSquares(int n) {
        int output = 0;
        String nums = Integer.toString(n);
        for(int i=0; i< nums.length(); i++){
            char c = nums.charAt(i);
            int digit = c - '0'; //here hwo to convert char to digit
            output = output + (digit*digit);
        }
        return output;
    }


    private int sumOfSquares_(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }
        return output;
    }
}