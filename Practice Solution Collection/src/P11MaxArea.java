/**
 * @Classname P11MaxArea
 * @Description TODO
 * @Date 2019/6/12 22:13
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P11MaxArea {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return result;
    }
}
