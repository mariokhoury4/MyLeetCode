/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int val = 1;

        while (top <= bottom && left <= right) {
            // left --> right
            for (int c = left; c <= right; c++) {
                result[top][c] = val;
                val = val + 1;
            }
            top = top + 1;

            // top --> bottom
            for (int c = top; c <= bottom; c++) {
                result[c][right] = val;
                val = val + 1;
            }
            right = right - 1;

            // left --> right
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result[bottom][c] = val;
                    val = val + 1;
                }
                bottom = bottom - 1;
            }

            // bottom --> top
            if (left <= right) {
                for (int c = bottom; c >= top; c--) {
                    result[c][left] = val;
                    val = val + 1;
                }
                left = left + 1;
            }
        }
        return result;
    }
}