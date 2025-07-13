/**
 * 6. Zigzag Conversion
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
class Solution {
    /**
     * Converts a conversation string into a zigzag pattern based on the specified number of rows.
     * @param conversation the conversation string to be converted
     * @param numRows the number of rows for the zigzag pattern
     * @return the converted string in zigzag format
     */
    public String convert(final String conversation, final int numRows) {
        // 1. Check if the number of rows is less than or equal to 1 and return the conversation as is.
        if (numRows <= 1) {
            return conversation;
        }

        // 2. Initialize an array of strings to hold each row of the zigzag pattern.
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 3. Initialize variables to track the direction of traversal and the current row.
        int direction = 1; // 1 for going down, - 1 for up;
        int currentRow = 0;

        // 4. Iterate through each character in the conversation string.
        for (int index = 0; index < conversation.length(); index++) {
            // 4.1 Append the current character to the current row.
            rows[currentRow].append(conversation.charAt(index));

            // 4.2 Flip direction at top or bottom row
            if (currentRow == 0) {
                direction = 1;
            } else if (currentRow == numRows - 1) {
                direction = -1;
            }
            currentRow = currentRow + direction;
        }
        // 5. Concatenate all rows to form the final zigzag string.
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        // 6. Return the final zigzag string.
        return result.toString();
    }
}