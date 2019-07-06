import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Classname P84MaxRectangleArea
 * @Description TODO
 * @Date 2019/6/2 12:09
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P84LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> queue = new ArrayDeque<>();
        int re = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (queue.isEmpty() || h >= heights[queue.peek()]) {
                queue.offerFirst(i);
            } else {
                int tmp = queue.poll();
                re = Math.max(re, heights[tmp] * (queue.isEmpty() ? i :  i - 1 - queue.peek()));
                i--;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] h = {5,1,3, 2, 3};
        int re = largestRectangleArea(h);
        System.out.println(re);
    }
}
