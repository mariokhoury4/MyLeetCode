/**
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    private static final String ZERO_STRING = "0";

    /**
     * Multiply 2 strings together
     * @param num1 first string
     * @param num2 second string
     * @return the multiplication result of both strings
     */
    public String multiply(String nums1, String nums2) {
        if (nums1.equals(ZERO_STRING) || nums2.equals(ZERO_STRING)) {
            return ZERO_STRING;
        }

        final int m = nums1.length();
        final int n = nums2.length();
        int[] prod = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int a = nums1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = nums2.charAt(j) - '0';

                int sum = prod[i + j + 1] + a * b;
                prod[i + j + 1] = sum % 10;
                prod[i + j] = prod[i + j] + sum / 10;
            }
        }
        // Build string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (k < prod.length && prod[k] == 0) k++;
        for (; k < prod.length; k++) {
            sb.append((char) ('0' + prod[k]));
        }
        return sb.toString();

    }
}