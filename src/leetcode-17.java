/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 *
 * --> 0 <= digits.length <= 4
 * --> digits[i] is a digit in the range ['2', '9'].
 */
class Solution {

    /**
     * Mapping of digits to their corresponding letters.
     */
    private static final Map<Character, String> DIGIT_TO_LETTERS = Map.ofEntries(
        Map.entry('2', "abc"),
        Map.entry('3', "def"),
        Map.entry('4', "ghi"),
        Map.entry('5', "jkl"),
        Map.entry('6', "mno"),
        Map.entry('7', "pqrs"),
        Map.entry('8', "tuv"),
        Map.entry('9', "wxyz")
    );

    /**
     * List to store the result combinations.
     */
    private List<String> result;

    /**
     * Find all possible letter combinations that the number could represent.
     * @param digits the input string containing digits from 2-9
     * @return a list of all possible letter combinations
     */
    public List<String> letterCombinations(final String digits) {
        // 1. Initialize the result list
        result = new ArrayList<>();

        // 2. Check if the input string is null or empty
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // 3. Start the recursive process to generate combinations
        getCombinations(digits, new StringBuilder());

        // 4. Return the result list containing all combinations
        return result;
    }

    /**
     * Recursive method to generate combinations of letters based on the digits.
     * @param digits the input string containing digits from 2-9
     * @param currentString the current combination being built
     */
    private void getCombinations(final String digits, final StringBuilder currentString) {
        // 1. Check if the current combination length matches the input digits length
        if (digits.length() == currentString.length()) {
            result.add(currentString.toString());
            return;
        }

        // 2. Get the letters corresponding to the current digit
        final String currentLetters = DIGIT_TO_LETTERS.get(digits.charAt(currentString.length()));

        // 3. Iterate through each letter and build combinations recursively
        for (int i = 0; i < currentLetters.length(); i++) {
            // 3.1 Append the current letter to the combination
            currentString.append(currentLetters.charAt(i));

            // 3.2 Recur to build the next level of combinations
            getCombinations(digits, currentString);

            // 3.3 Backtrack by removing the last character added
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}