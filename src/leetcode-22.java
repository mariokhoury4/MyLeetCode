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
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        generateParenthesisRecursive("", n, 0, result);
        return new ArrayList<>(result);
    }

    private void generateParenthesisRecursive(String current, int n, int currentOpen, Set<String> result) {
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