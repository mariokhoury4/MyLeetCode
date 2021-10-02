import java.util.*;
public class leetcode37 {
    class Solution {
        public List<Integer> neighbords(char[][] board, int i, int j){
                List<Integer> res = new ArrayList<>();
                for(int z = 1; z < 10; z++){
                    res.add(z);
                }
                for(int z = 0; z < 9; z++){
                    if(board[i][z] != '.') res.remove(new Integer(board[i][z]- '0'));
                    if(board[z][j] != '.') res.remove(new Integer(board[z][j]- '0'));
                    if(board[i/3*3+ z/3][j/3*3 +z%3] != '.') res.remove(new Integer(board[i/3*3+ z/3][j/3*3 +z%3]- '0') );
                }
                return res;
            }
            
            public boolean rec(char[][] board, int i, int j){
                if(i == board.length && j == board.length){
                    return true;
                }
                while(board[i][j] != '.'){
                    if(j == 8){
                        i++;
                        j = 0;
                    }else{
                        j++;
                    }
                    if(i == 8 && j == 8) break;
                    if(i > 8) break;
                    if(j > 8) break;
                    
                }
                if(i > 8) return true;
                if(j > 8) return true;
                if(i == 8 && j == 8 && board[8][8] != '.') return true;
                
                List<Integer> neigh = neighbords(board, i, j);
                for(int z = 0; z < neigh.size(); z++){
                    board[i][j] = (char)(neigh.get(z) + '0');
                    if(rec(board, i, j)) return true;
                    board[i][j] = '.';
                    
                    
                }
                return false;
            }
            
            
            public void solveSudoku(char[][] board) {
                rec(board, 0, 0);
                return;
            }
        }
}
