import java.util.*;
public class leetcode36 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for(int i = 0; i < board.length; i++){
                Set<Character> row = new HashSet<>();
                Set<Character> col = new HashSet<>();
                Set<Character> square = new HashSet<>();
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                    if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                    int r = i / 3 * 3 + j / 3, c = i % 3 * 3 + j % 3;
                    if (board[r][c] != '.' && !square.add(board[r][c])) return false;
                }
            }
            return true;
        }
    }
    
    
    
    
    
    
    
}
