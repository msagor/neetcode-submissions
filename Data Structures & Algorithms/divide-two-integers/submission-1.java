

//Leetcode - https://leetcode.com/problems/divide-two-integers/

class Solution {
    public int divide(int dividend, int divisor) {

        //nHandle division by zero
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }

        // If dividend == divisor, return 1 immediately.
        if (dividend == divisor) {
            return 1;
        }

        // If divisor == 1, return dividend directly.
        if (divisor == 1) {
            return dividend;
        }

        //XOR is true when exactly one operand is negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        //Convert to long BEFORE Math.abs()
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        //Use long to prevent quotient overflow
        long quotient = 0;

        while (a >= b) {
            long currentDivisor = b;
            long multiple = 1;

            while (a >= currentDivisor + currentDivisor) {
                currentDivisor += currentDivisor;
                multiple += multiple;
            }

            a -= currentDivisor;
            quotient += multiple;
        }

        //Apply the sign while still using long
        long result = negative ? -quotient : quotient;

        //here: Clamp the result to the int range
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
