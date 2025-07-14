/**
 * 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Constraints:
 * -231 <= x <= 231 - 1
 */
class Solution {
    /**
     * Reverses the digits of a signed 32-bit integer.
     * @param number the signed 32-bit integer to be reversed
     * @return the reversed integer, or 0 if the reversed integer is outside the signed 32-bit integer range
     */
    public int reverse(int number) {
        // 1. Initialize a variable to hold the reversed number.
        int reversedNumber = 0;

        // 2. Loop until the number becomes 0.
        while (number != 0) {
            // 2.1 Check for overflow conditions for positive numbers.
            if (reversedNumber > Integer.MAX_VALUE / 10 || (reversedNumber == Integer.MAX_VALUE / 10 && number % 10 > 7)) {
                return 0;
            }
            // 2.2 Check for underflow conditions for negative numbers.
            if (reversedNumber < Integer.MIN_VALUE / 10 || (reversedNumber == Integer.MIN_VALUE / 10 && number % 10 < -8)) {
                return 0;
            }
            // 3. Update the reversed number by multiplying it by 10 and adding the last digit of the number.
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        // 4. Return the reversed number.
        return reversedNumber;
    }
}