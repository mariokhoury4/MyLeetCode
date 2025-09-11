/**
 * 38. Count and Say
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 *
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: "1211"
 *
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: "1"
 *
 * Explanation:
 * This is the base case.
 *
 * Constraints:
 * 1 <= n <= 30
 *
 *
 * Follow up: Could you solve it iteratively?
 */
class Solution {
    /**
     * 38. Count and Say
     * @param n the nth element of the count-and-say sequence
     * @return the nth element of the count-and-say sequence
     */
    public String countAndSay(final int n) {
        // 1. Base case
        if (n == 1) {
            return "1";
        }
        //2 . Iteratively build the sequence from 1 to n
        String result = "1";

        // 3. Iterate from 1 to n-1 to build the sequence
        for (int i = 1; i < n; i++) {
            // 3.1 Use two pointers to count the number of consecutive identical characters
            StringBuilder temp = new StringBuilder();
            int slow = 0;
            int fast = 0;

            // 3.2 Iterate through the string using the two pointers
            while (fast < result.length()) {
                // 3.2.1 If the characters at the two pointers are the same, move the fast pointer
                if (result.charAt(slow) == result.charAt(fast)) {
                    fast = fast + 1;
                } else {
                    temp.append(fast - slow);
                    temp.append(result.charAt(slow));
                    slow = fast;
                }

                // 3.2.2 If the fast pointer reaches the end of the string, append the count and character to the result
                if (fast == result.length()) {
                    temp.append(fast - slow);
                    temp.append(result.charAt(slow));
                }
            }
            // 3.3 Update the result for the next iteration
            result = temp.toString();
        }

        // 4. Return the final result
        return result;
    }
}