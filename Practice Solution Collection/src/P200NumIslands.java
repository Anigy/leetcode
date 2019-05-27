public class P200NumIslands {
    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == 'o') continue;
                else {
                    travel(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public static void travel(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '1') {
            grid[i][j] = 'o';
            travel(grid, i, j - 1);
            travel(grid, i + 1, j);
            travel(grid, i, j + 1);
            travel(grid, i - 1, j);
        }
    }

    public static void main(String[] args) {
        char[][] c = {{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};
        int a = numIslands(c);
    }
}
