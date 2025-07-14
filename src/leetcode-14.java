/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * --> 1 <= strs.length <= 200
 * --> 0 <= strs[i].length <= 200
 * --> strs[i] consists of only lowercase English letters if it is non-empty.
 */
class Solution {

    /**
     * Default prefix to return when no common prefix is found.
     */
    private static final String DEFAULT_PREFIX = "";

    /**
     * Finds the longest common prefix among an array of strings.
     * @param strs the array of strings to check for a common prefix
     * @return the longest common prefix string, or an empty string if there is no common prefix
     */
    public String longestCommonPrefix(final String[] strs) {
        // 1. Check if the input array is null or empty.
        if (strs == null || strs.length == 0) {
            return DEFAULT_PREFIX;
        }

        // 2. Save the first string as the initial longest prefix.
        String longestPrefix = strs[0];

        // 3. Iterate through the array of strings starting from the second string.
        for (String str : strs) {
            longestPrefix = getLongestPrefixOfTwoStrings(longestPrefix, str);
            // 3.1 If at any point the longest prefix becomes empty, we can return the default prefix immediately.
            if (longestPrefix.length() == 0) {
                return DEFAULT_PREFIX;
            }
        }

        // 4. If the longest prefix is empty, return the default prefix.
        return longestPrefix;
    }

    /**
     * Finds the longest common prefix of two strings.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return the longest common prefix of the two strings
     */
    private String getLongestPrefixOfTwoStrings(final String str1, final String str2) {
        // 1. Get the minimum length of the two strings to avoid IndexOutOfBoundsException.
        final int minLength = Math.min(str1.length(), str2.length());

        // 2. Create a StringBuilder to build the prefix.
        final StringBuilder prefixBuilder = new StringBuilder();

        // 3. Iterate through the characters of both strings up to the minimum length.
        for (int index = 0; index < minLength; index++) {
            // 4. Check if the characters at the current index are different, if so return the prefix built so far.
            if (str1.charAt(index) != str2.charAt(index)) {
                return prefixBuilder.toString();
            }

            // 5. Append the character from the first string to the prefix.
            prefixBuilder.append(str1.charAt(index));
        }
        // 6. If we reach here, it means all characters matched up to the minimum length.
        return prefixBuilder.toString();
    }
}