/**
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * --> 0 <= s.length <= 3 * 104
 * --> s[i] is '(', or ')'.
 */

class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize stack with -1 to handle edge cases

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    stack.push(i); // Push current index if stack is empty
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }

        return result;

    }
}