/**
 * @Classname P96NumTrees
 * @Description TODO
 * @Date 2019/6/2 9:43
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P96NumTrees {
    public static int numTrees(int n) {
        int[] re = new int[n + 1];
        re[0] = 1;
        re[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp += re[j] * re[i - j - 1];
            }
            re[i] = tmp;
        }
        return re[n];
    }

    public static void main(String[] args) {
        int n = numTrees(3);
        System.out.println(n);
    }
}
