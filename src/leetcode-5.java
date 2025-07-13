/**
 * 5. Longest Palindromic Substring
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class Solution {
    public String longestPalindrome(final String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        // 1. Storing the longest palindrom found so far in the str.
        String longestPalindrome = "";

        // 2. Save the currentLength of the palindrome that is getting extended.
        int currentLength = 0;

        // 3. Iterate through the string to find palindromes.
        for (int i = 0; i < str.length() - 1; i++) {
            currentLength = 1 + extendFromMiddle(str, i - 1, i + 1);
            if (currentLength > longestPalindrome.length()) {
                longestPalindrome = str.substring(i - currentLength / 2, i + currentLength / 2 + 1);
            }
            if (str.charAt(i) == str.charAt(i + 1)) {
                currentLength = 2 + extendFromMiddle(str, i - 1, i + 2);
                if (currentLength > longestPalindrome.length()) {
                    longestPalindrome = str.substring(i - (currentLength - 1) / 2, i + currentLength / 2 + 1);
                }
            }
        }
        // Return the longest palindrome.
        return longestPalindrome;

    }

    /**
     * Extend the palindrome from the middle indices leftIndex and rightIndex.
     * @param str the input string
     * @param leftIndex
     * @param rightIndex
     * @return the length of the palindrome found
     */
    private int extendFromMiddle(final String str, int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= str.length()) {
            return 0;
        }
        if (str.charAt(leftIndex) == str.charAt(rightIndex)) {
            return 2 + extendFromMiddle(str, leftIndex - 1, rightIndex + 1);
        }
        return 0;
    }
}