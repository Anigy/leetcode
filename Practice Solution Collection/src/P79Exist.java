/**
 * @Classname P79Exist
 * @Description TODO
 * @Date 2019/6/3 21:39
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P79Exist {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(helper(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] b, String s, int i, int j, int index) {
        if (index == s.length()) {
            return true;
        }
        if (i < 0 || i == b.length || j < 0 || j == b[0].length ||b[i][j] != s.charAt(index)) return false;
        char tmp = b[i][j];
        b[i][j] = '0';
        if (helper(b, s, i, j - 1, index + 1) ||
                helper(b, s, i - 1, j, index + 1) ||
                helper(b, s, i, j + 1, index + 1) ||
                helper(b, s, i + 1, j, index + 1)) {
            return true;
        }
        b[i][j] = tmp;
        return false;
    }
}
