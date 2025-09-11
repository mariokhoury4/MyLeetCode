/**
 * 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 * Exple 1:
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 */
class Solution {
    /**
     * 37. Sudoku Solver
     * @param board a 9x9 2D array representing the Sudoku board
     */
    public void solveSudoku(char[][] board) {
        recursiveSolver(board, 0, 0);
        return;
    }

    /**
     * A recursive backtracking function to solve the Sudoku puzzle
     * @param board the Sudoku board
     * @param row the current row
     * @param column the current column
     * @return true if the board is solved, false otherwise
     */
    private boolean recursiveSolver(char[][] board, int row, int column) {
        // 1. Base case: if we have reached the end of the board, return true
        if (row == board.length && column == board.length) {
            return true;
        }

        // 2. Find the next empty cell
        while(board[row][column] != '.') {
            // 2.1 Move to the next cell
            if (column == 8) {
                row = row + 1;
                column = 0;
            } else {
                column = column + 1;
            }

            // 2.2 If we have reached the end of the board, return true
            if ((row == 8 && column == 8) || row > 8 || column > 8) {
                break;
            }
        }
        // 3. If we have reached the end of the board, return true
        if ((row == 8 && column == 8) || row > 8 || column > 8) {
            return true;
        }

        // 4. Get the list of possible numbers for the current cell
        final List<Integer> neighbords = getNeighbords(board, row, column);

        // 5. Try each possible number
        for (int i = 0; i < neighbords.size(); i++) {
            // 5.1 Place the number in the cell
            board[row][column] = (char) (neighbords.get(i) + '0');

            // 5.2 Recursively try to solve the board
            if (recursiveSolver(board, row, column)) {
                return true;
            }
            // 5.3 If the board cannot be solved, remove the number from the cell
            board[row][column] = '.';
        }
        // 6. If no number can be placed in the cell, return false
        return false;
    }

    /**
     * Get the list of possible numbers for a given cell
     * @param board the Sudoku board
     * @param row the current row
     * @param column the current column
     * @return a list of possible numbers for the cell
     */
    private List<Integer> getNeighbords(char[][] board, int row, int column) {
        // 1. Initialize a list of numbers from 1 to 9
        List<Integer> neighboards = new ArrayList<>();

        // 2. Remove numbers that are already in the same row, column, or 3x3 sub-box
        for (int i = 1; i < 10; i++) {
            neighboards.add(i);
        }

        // 3. Check the row, column, and 3x3 sub-box
        for (int i = 0; i < 9; i++) {
            // 3.1 If the number is already in the row, column, or 3x3 sub-box, remove it from the list
            if (board[row][i] != '.') {
                neighboards.remove(Integer.valueOf((int) board[row][i] - '0'));
            }

            // 3.2 If the number is already in the column, remove it from the list
            if (board[i][column] != '.' ) {
                neighboards.remove(Integer.valueOf((int) board[i][column] - '0'));
            }

            // 3.3 If the number is already in the 3x3 sub-box, remove it from the list
            if (board[row / 3 * 3 + i / 3][column / 3 * 3 + i % 3] != '.') {
                neighboards.remove(Integer.valueOf((int) board[row / 3 * 3 + i / 3][column / 3 * 3 + i % 3] - '0'));
            }
        }

        // 4. Return the list of possible numbers
        return neighboards;
    }
}