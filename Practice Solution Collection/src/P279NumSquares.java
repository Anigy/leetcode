public class P279NumSquares {
    public static int numSquares(int n) {
        int[] nums = new int[100000];
        int len = 0;
        int index = 1;
        int tmp = index * index;
        while (tmp < n) {
            nums[len++] = tmp;
            index++;
            tmp = index * index;
        }
        if (tmp == n) return 1;
        int[][] result = new int[len + 1][n + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) result[i][j] = 0;
                else if (i == 1) result[i][j] = j;
                else result[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k * nums[i - 1] <= j; k++) {
                    if (result[i - 1][j - k * nums[i - 1]] != Integer.MAX_VALUE)
                        result[i][j] = Math.min(result[i - 1][j], result[i][j - k * nums[i - 1]] + k);
                }
            }
        }
        return result[len][n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(7927));
    }
}
