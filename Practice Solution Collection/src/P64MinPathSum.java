/**
 * @Classname P64MinPathSum
 * @Description TODO
 * @Date 2019/6/7 22:19
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P64MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] min = new int[grid.length][grid[0].length];
        min[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            min[i][0] = min[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            min[0][j] = min[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
            }
        }
        return min[grid.length - 1][grid[0].length - 1];
    }
}
