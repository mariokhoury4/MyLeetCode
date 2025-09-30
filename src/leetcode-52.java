/**
 * 52. N-Queens II
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example 1:
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
class Solution {
    public int totalNQueens(int n) {
        Set<Integer> diagonal = new HashSet<>();
        Set<Integer> antiDiagonal = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        return recursiveSolve(new ArrayList<>(), n, diagonal, antiDiagonal, columns);
    }

    private int recursiveSolve(List<String> temp, int n, Set<Integer> diagonal, Set<Integer> antiDiagonal, Set<Integer> columns) {
        int row = temp.size();
        if (row == n) {
            return 1;
        }

        StringBuilder currentString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            currentString.append('.');
        }

        int solution = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col;
            if (columns.contains(col) || diagonal.contains(d1) || antiDiagonal.contains(d2)) {
                continue;
            }

            currentString.setCharAt(col, 'Q');
            diagonal.add(d1);
            antiDiagonal.add(d2);
            columns.add(col);

            temp.add(currentString.toString());
            solution = solution + recursiveSolve(temp, n, diagonal, antiDiagonal, columns);

            temp.remove(temp.size() - 1);
            currentString.setCharAt(col, '.');
            diagonal.remove(d1);
            antiDiagonal.remove(d2);
            columns.remove(col);
        }
        return solution;
    }
}