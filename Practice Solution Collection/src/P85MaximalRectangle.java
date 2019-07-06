import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname P85MaximalRectangle
 * @Description TODO
 * @Date 2019/6/2 17:59
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P85MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int re = 0;
        if (matrix.length == 0) return 0;
        Deque<Integer> queue = new ArrayDeque<>();
        int[][] h = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) h[0][i] = matrix[0][i] == '0' ? 0 : 1;
                else h[j][i] = matrix[j][i] == '0' ? 0 : h[j - 1][i] + 1;
            }
        }
        for (int i = 0; i < h.length; i++) {
            queue.clear();
            for (int j = 0; j <= h[0].length; j++) {
                int he = j == h[0].length ? 0 : h[i][j];
                if (queue.isEmpty() || he >= h[i][queue.peek()]) {
                    queue.offerFirst(j);
                } else {
                    int tmp = queue.poll();
                    re = Math.max(re, h[i][tmp] * (queue.isEmpty() ? j : j - 1 - queue.peek()));
                    j--;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        char[][] c = {{'0', '1'}};
        int re = maximalRectangle(c);
    }
}
