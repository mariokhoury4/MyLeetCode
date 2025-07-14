/**
 * 9. Palindrome Number
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
class Solution {
    /**
     * Checks if a given integer is a palindrome.
     * @param number the integer to be checked
     * @return true if the integer is a palindrome, false otherwise
     */
    public boolean isPalindrome(final int number) {
        // 1. Check if the number is negative. If it is, return false since negative numbers cannot be palindromes.
        if (number < 0) {
            return false;
        }

        // 2. Check if the number is equal to the reverted number.
        return revert(number) == number;
    }

    /**
     * Reverts the digits of a given integer.
     * @param number the integer to be reverted
     * @return the reverted integer
     */
    private int revert(int number) {
        int revertedNumber = 0;
        while (number != 0) {
            if (revertedNumber > Integer.MAX_VALUE / 10 || (revertedNumber == Integer.MAX_VALUE / 10 && number % 10 > 7)) {
                return -1; // Overflow condition for positive numbers
            }
            revertedNumber = revertedNumber * 10 + number % 10;
            number = number / 10;
        }
        return revertedNumber;
    }
}