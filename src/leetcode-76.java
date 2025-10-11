/**
 * 76. Minimum Window Substring
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        // Count of required chars (supports uppercase + lowercase ASCII)
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int remaining = t.length();  // how many required chars still missing
        int left = 0, right = 0;
        int bestStart = 0, bestLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rc = s.charAt(right);
            right = right + 1;

            if (need[rc]-- > 0) {
                remaining = remaining - 1;
            }

            while (remaining == 0) {
                if (right - left < bestLen) {
                    bestLen = right - left;
                    bestStart = left;
                }
                char lc = s.charAt(left);
                left = left + 1;
                if (++need[lc] > 0) {
                    remaining = remaining + 1;
                }
            }

        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);

    }
}