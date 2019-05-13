public class P221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;
        int re = 0;
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            result[i][0] = matrix[i][0] == '1' ? 1 : 0;
            re = Math.max(re, result[i][0]);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            result[0][j] = matrix[0][j] == '1' ? 1 : 0;
            re = Math.max(re, result[0][j]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    result[i][j] = Math.min(result[i-1][j], Math.min(result[i-1][j-1], result[i][j-1])) + 1;
                    re = Math.max(re, result[i][j]);
                }
            }
        }
        return re * re;
    }
}
