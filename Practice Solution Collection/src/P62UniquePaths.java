/**
 * @Classname P62UniquePaths
 * @Description TODO
 * @Date 2019/6/7 23:01
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        return count[m - 1][n - 1];
    }
}
