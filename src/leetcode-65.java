/**
 * 65. Valid Number
 * Given a string s, return whether s is a valid number.
 *
 * For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".
 *
 * Formally, a valid number is defined using one of the following definitions:
 *
 * An integer number followed by an optional exponent.
 * A decimal number followed by an optional exponent.
 * An integer number is defined with an optional sign '-' or '+' followed by digits.
 *
 * A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
 *
 * Digits followed by a dot '.'.
 * Digits followed by a dot '.' followed by digits.
 * A dot '.' followed by digits.
 * An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.
 *
 * The digits are defined as one or more digits.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "0"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "e"
 *
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "."
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 */
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        } else if (s.length() == 1) {
            if (!Character.isDigit(s.charAt(0))) {
                return false;
            }
        }

        String[] expression = splitOnE(s);
        if (expression == null) {
            return false;
        }
        if (s.contains("e") || s.contains("E")) {
            if (expression.length != 2) {
                return false;
            }
        }
        if (expression.length > 2) {
            return false;
        } else if (expression.length == 2) {
            if (expression[0] == null || expression[0] == "" || expression[1] == null || expression[1] == "") {
                return false;
            }
        }
        for (int i = 0; i < expression.length; i++) {
            String cur = expression[i];
            int countDot = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) == '+' || cur.charAt(j) == '-') {
                    if (j != 0) {
                        return false;
                    } else if (j == cur.length() - 1) {
                        return false;
                    }
                } else if (cur.charAt(j) == '.') {
                    if (i == 1) {
                        return false;
                    } else if (countDot == 1) {
                        return false;
                    }
                    if (j == 0 && j == cur.length() - 1) {
                        return false;
                    }
                    if (j > 0 && (cur.charAt(j - 1) == '+' || cur.charAt(j - 1) == '-') && j == cur.length() - 1) {
                        return false;
                    }
                    countDot = 1;
                } else if (!Character.isDigit(cur.charAt(j))) {
                    return false;
                }
            }
        }
        return true;

    }

    private String[] splitOnE(String s) {
        s = s.replaceAll("E", "e");
        if (s.chars().filter(c -> c == 'e').count() > 1) {
            return null;
        }
        return s.split("e");
    }
}