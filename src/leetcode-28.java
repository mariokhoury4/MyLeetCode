/**
 * 28. Find the Index of the First Occurrence in a String
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 *
 * --> 1 <= haystack.length, needle.length <= 104
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            int j = 0;
            while (j < needle.length() && needle.charAt(j) == haystack.charAt(i + j)) {
                j = j + 1;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;

    }
}