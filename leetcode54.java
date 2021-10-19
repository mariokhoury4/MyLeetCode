import java.util.*;
public class leetcode54{

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            boolean up = false;
            boolean down = false;
            boolean left = false;
            boolean right = true;
            
            List<Integer> res = new ArrayList<>();
            if(matrix[0].length == 1){
                right = false;
                down = true;
            }
            if(row == 1 && col == 1){
                res.add(matrix[0][0]);
                return res;
            }
            if(matrix.length == 0) return res;
            int i = 0;
            int j = 0;
            int limitr = 1;
            int limitc = 0;
            while(res.size() < matrix.length * matrix[0].length){
                res.add(matrix[i][j]);
                if(right)j++;
                if(left) j--;
                if(up) i--;
                if(down) i++;
                if(right && j == col - 1){
                    right = false;
                    down = true;
                    col--;
                }else if(down && i == row - 1){
                    down = false;
                    left = true;
                    row--;
                }else if (left && j == limitc){
                    left = false;
                    up = true;
                    limitc++;
                }else if(up && i == limitr){
                    up = false;
                    right = true;
                    limitr++;
                }
            }
            return res;
        }
    }
}