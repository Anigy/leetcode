/**
 * @Classname P48Rotate
 * @Description TODO
 * @Date 2019/6/8 11:35
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P48Rotate {
    public void rotate(int[][] matrix) {
        int tmp;
        for (int i = 0; i < matrix.length / 2 + matrix.length % 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = tmp;
            }
        }
    }
}
