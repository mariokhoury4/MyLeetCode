public class leetcode59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            
            
            int counter = 1;
            int i = 0;
            int j = 0;
            int Maxrow = n;
            int Maxcol = n;
            int Minrow = 0;
            int Mincol = -1;
            boolean up = false;
            boolean down = false;
            boolean right = true;
            boolean left = false;
            while(counter != n * n + 1){
                result[i][j] = counter;
                if(right)j++;
                if(left) j--;
                if(up)i--;
                if(down)i++;
                if(right && j == Maxcol){
                    right = false;
                    down = true;
                    j--;
                    i++;
                    Maxcol--;
                }else if(down && i == Maxrow){
                    down = false;
                    left = true;
                    i--;
                    j--;
                    Maxrow--;
                }else if(left && j == Mincol){
                    left = false;
                    up = true;
                    j++;
                    i--;
                    Mincol++;
                }else if(up && i == Minrow){
                    up = false;
                    right = true;
                    i++;
                    j++;
                    Minrow++;
                }
                counter++;
            }
            return result;
            
        }
    }
}
