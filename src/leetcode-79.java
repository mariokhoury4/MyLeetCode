/**
 * 79. Word Search
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result = result || rec(board, visited, word, i, j, "");
                if (result) {
                    return result;
                }
            }
        }
        return result;
    }
    private boolean rec(char[][] board, boolean[][] visited, String word, int i, int j, String cur) {
        if (cur.equals(word)) {
            return true;
        }
        char temp = word.charAt(cur.length());

        boolean result = false;

        if (!visited[i][j] && board[i][j] == temp) {
            visited[i][j] = true;
            // after consuming current cell, look for the next char from neighbors
            // call rec with same (i,j) so the next level checks neighbors using the next char
            result = result || rec(board, visited, word, i, j, cur + temp);
            visited[i][j] = false;
            if (result) return true;
        }
        if (i > 0 && board[i - 1][j] == temp && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            result = result || rec(board, visited, word, i - 1, j, cur + temp);
            visited[i - 1][j] = false;
        }

        if (j > 0 && board[i][j - 1] == temp && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            result = result || rec(board, visited, word, i , j - 1, cur + temp);
            visited[i][j - 1] = false;
        }

        if (i < board.length - 1 && board[i + 1][j] == temp && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            result = result || rec(board, visited, word, i + 1 , j, cur + temp);
            visited[i + 1][j] = false;
        }

        if (j < board[0].length - 1 && board[i][j + 1] == temp && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            result = result || rec(board, visited, word, i, j + 1, cur + temp);
            visited[i][j + 1] = false;
        }
        return result;
    }
}