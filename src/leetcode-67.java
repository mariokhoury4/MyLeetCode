/**
 * 67. Add Binary
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        final String longest = a.length() >= b.length() ? a : b;
        final String shortest = a.length() >= b.length() ? b : a;

        int index = shortest.length() - 1;
        int carry = 0;
        for (int i = longest.length() - 1; i >= 0; i--) {
            int temp = (longest.charAt(i) - '0') + carry;
            if (index >= 0) {
                temp = temp + (shortest.charAt(index) - '0');
            }
            result.append("" + temp % 2);
            carry = temp / 2;
            index = index - 1;
        }
        if (carry != 0) {
            result.append("" + carry);
        }
        result.reverse();
        return result.toString();
    }
}