/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * --> 1 <= n <= 8
 */
class Solution {
    /**
     * Generate all combinations of well-formed parentheses.
     * @param n the number of pairs of parentheses.
     * @return a list of strings representing all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(final int n) {
        Set<String> result = new HashSet<>();
        generateParenthesisRecursive("", n, 0, result);
        return new ArrayList<>(result);
    }

    /**
     * Recursive helper method to generate parentheses combinations.
     * @param current the current string being built.
     * @param n the total number of pairs of parentheses.
     * @param currentOpen the number of open parentheses in the current string.
     * @param result the set to store unique combinations of parentheses.
     */
    private void generateParenthesisRecursive(String current, final int n, int currentOpen, Set<String> result) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        if (currentOpen == n) {
            while (current.length() < n * 2) {
                current = current + ')';
            }
            result.add(current);
            return;
        }
        generateParenthesisRecursive(current + '(', n, currentOpen + 1, result);
        if (currentOpen > current.length() - currentOpen) {
            generateParenthesisRecursive(current + ')', n, currentOpen, result);
        }
    }
}