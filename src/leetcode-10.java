/**
 * 10. Regular Expression Matching
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Constraints:
 * --> 1 <= s.length <= 20
 * --> 1 <= p.length <= 20
 * --> s contains only lowercase English letters.
 * --> p contains only lowercase English letters, '.', and '*'.
 * --> It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 */
class Solution {
    /**
     * Checks if the input string matches the pattern using regular expression matching rules.
     * @param s the input string to be matched
     * @param p the pattern string that may contain '.' and '*'
     * @return true if the input string matches the pattern, false otherwise
     */
    public boolean isMatch(final String str, final String pattern) {
        return isMatch(str, pattern, 0, 0);
    }

    /**
     * Recursive helper method to check if the input string matches the pattern.
     * @param str the input string to be matched
     * @param pattern the pattern string that may contain '.' and '*'
     * @param strIndex the current index in the input string
     * @param patternIndex the current index in the pattern string
     * @return
     */
    private boolean isMatch(final String str, final String pattern, int strIndex, int patternIndex) {
        if (pattern.length() == patternIndex) {
            return str.length() == strIndex;
        }

        boolean currentMatch = (strIndex < str.length() && (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.'));

        // Handle '*'
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
            // Case 1: '*' matches 0 occurrences (skip pattern by 2)
            // Case 2: '*' matches 1+ occurrences (if current match, advance s only)
            return isMatch(str, pattern, strIndex, patternIndex + 2) ||
                    (currentMatch && isMatch(str, pattern, strIndex + 1, patternIndex));
        }
        // If no '*', proceed normally
        return currentMatch && isMatch(str, pattern, strIndex + 1, patternIndex + 1);
    }
}