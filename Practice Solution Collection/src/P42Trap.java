import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Classname P42Trap
 * @Description TODO
 * @Date 2019/6/8 18:42
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P42Trap {
    public static int trap(int[] height) {
        if(height.length < 3) return 0;
        int result = 0;
        int[] mark = new int[height.length];
        mark[0] = 0;
        for (int i = 1; i < height.length; i++) {
            mark[i] = Math.max(mark[i - 1], height[i - 1]);
        }
        int r = height[height.length - 1];
        for(int i = height.length - 2; i > 0; i--) {
            r = Math.max(r, height[i]);
            if(mark[i] == height[i]) continue;
            else {
                int maxH = Math.min(mark[i], r);
                if(maxH > height[i]) result += maxH - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int re = trap(height);
        System.out.println(re);
    }
}
