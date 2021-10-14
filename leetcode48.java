
public class leetcode48{
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < (n + 1) / 2; i ++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                    matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                    matrix[j][n - 1 - i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }
    }
    class Solution1 {
        public void rotate(int[][] matrix) {
            for(int i = 0; i < matrix.length; i++){
                for(int j = i; j < matrix[i].length; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    
                }
            }
            
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = temp;
                }
            }
        }
    }
}