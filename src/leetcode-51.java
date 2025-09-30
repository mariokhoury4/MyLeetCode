/**
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        Set<Integer> diagonale = new HashSet<>(); // r - c
        Set<Integer> antiDiagonale = new HashSet<>(); // r + c
        Set<Integer> columns = new HashSet<>();

        recursiveSolve(new ArrayList<>(), n, diagonale, antiDiagonale, columns, result);
        return result;

    }

    private void recursiveSolve(List<String> temp, int n, Set<Integer> diagonale, Set<Integer> antiDiagonale, Set<Integer> columns, List<List<String>> result) {
        int row = temp.size();
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        StringBuilder current = new StringBuilder();
        for (int i = 0; i < n; i++) {
            current.append(".");
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col; // main diagonal key
            int d2 = row + col; // anti diagonal key

            if (columns.contains(col) || diagonale.contains(d1) || antiDiagonale.contains(d2)) {
                continue;
            }

            // place
            current.setCharAt(col, 'Q');
            temp.add(current.toString());
            columns.add(col);
            diagonale.add(d1);
            antiDiagonale.add(d2);

            // recursive
            recursiveSolve(temp, n, diagonale, antiDiagonale, columns, result);

            // backtrack
            antiDiagonale.remove(d2);
            diagonale.remove(d1);
            columns.remove(col);
            temp.remove(temp.size() -1);
            current.setCharAt(col, '.');
        }
    }
}