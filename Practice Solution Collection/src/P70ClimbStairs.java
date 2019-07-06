/**
 * @Classname P70ClimbStairs
 * @Description TODO
 * @Date 2019/6/7 22:13
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P70ClimbStairs {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int[] re = new int[n + 1];
        re[0] = 0;
        re[1] = 1;
        re[2] = 2;
        for (int i = 3; i <= n; i++) {
            re[i] = re[i - 1] + re[i - 2];
        }
        return re[n];
    }
}
