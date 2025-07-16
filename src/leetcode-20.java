/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * --> Open brackets must be closed by the same type of brackets.
 * --> Open brackets must be closed in the correct order.
 * --> Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 * Constraints:
 *
 * --> 1 <= s.length <= 104
 * --> s consists of parentheses only '()[]{}'.
 */
class Solution {

    /**
     * Define the valid parentheses characters.
     */
    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';
    private static final char OPEN_BRACE = '{';
    private static final char CLOSE_BRACE = '}';
    private static final char OPEN_BRACKET = '[';
    private static final char CLOSE_BRACKET = ']';

    /**
     * Check if the given string is a valid parentheses string.
     * @param stringToValidate the string to validate.
     * @return true if the string is valid, false otherwise.
     */
    public boolean isValid(final String stringToValidate) {
        // 1. Initialize a stack to keep track of the open parentheses.
        Stack<Character> stack = new Stack<>();

        // 2. Iterate through each character in the string.
        for (int i = 0; i < stringToValidate.length(); i++) {

            // 2.1 Check if the character is a closing parenthesis.
            final char c = stringToValidate.charAt(i);

            // 2.2 If it is a closing parenthesis, check if it matches the last open parenthesis in the stack.
            if (c == CLOSE_PARENTHESIS) {
                if (stack.isEmpty() || stack.peek() != OPEN_PARENTHESIS) {
                    return false;
                }
                stack.pop();
            } else if (c == CLOSE_BRACE) {
                if (stack.isEmpty() || stack.peek() != OPEN_BRACE) {
                    return false;
                }
                stack.pop();
            } else if (c == CLOSE_BRACKET) {
                if (stack.isEmpty() || stack.peek() != OPEN_BRACKET) {
                    return false;
                }
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        // 4. Check if the stack is empty at the end. If not return false.
        if (stack.size() != 0) {
            return false;
        }
        return true;

    }
}