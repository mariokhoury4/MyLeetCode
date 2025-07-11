/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 104
 * - s consists of English letters, digits, symbols and spaces.
 */
class Solution {
    /**
     * Find the length of the longest substring without repeating characters.
     *
     * @param inputString a string input
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(final String inputString) {
        // 1. Initialize a set to keep track of seen ASCI characters.
        int[] indexMap = new int[128];

        // 2. Initialize the set with indices to -1
        Arrays.fill(indexMap, -1);

        // 3. Initialize two pointers for the sliding window.
        int windowStart = 0;
        int maxLength = 0;

        // 4. Iterate through the string with a sliding window approach.
        for (int windowEnd = 0; windowEnd < inputString.length(); windowEnd++) {
            final char currentChar = inputString.charAt(windowEnd);

            // 5. Shrink window from the left if duplicate is found
            while (indexMap[currentChar] != -1) {
                indexMap[inputString.charAt(windowStart)] = -1;
                windowStart++;
            }
            indexMap[currentChar] = 1;
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}



