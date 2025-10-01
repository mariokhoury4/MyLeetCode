class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int startCol = 0;
        int endCol = matrix[0].length - 1;

        int startRow = 0;
        int endRow = matrix.length - 1;


        while (startCol <= endCol && startRow <= endRow) {
            // go right
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow = startRow + 1;

            // go down
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol = endCol - 1;

            // go left (only if still within rows)
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
                endRow = endRow - 1;
            }

            // go up (only if still within cols)
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                startCol = startCol + 1;
            }
        }
        return result;
    }
}