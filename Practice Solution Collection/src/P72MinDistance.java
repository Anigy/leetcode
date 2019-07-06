/**
 * @Classname P72MinDistance
 * @Description TODO
 * @Date 2019/6/7 21:51
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P72MinDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dis = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) dis[i][j] = j;
                else if (j == 0) dis[i][j] = i;
                else dis[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int tmp = Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1);
                dis[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ?
                        Math.min(tmp, dis[i - 1][j - 1]) : Math.min(tmp, dis[i - 1][j - 1] + 1);
            }
        }
        return dis[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String w1 = "horse";
        String w2 = "ros";
        int re = minDistance(w1, w2);
    }
}
