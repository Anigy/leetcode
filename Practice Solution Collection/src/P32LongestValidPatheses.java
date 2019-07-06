import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname P32LongestValidPatheses
 * @Description TODO
 * @Date 2019/6/9 11:50
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P32LongestValidPatheses {
    public static int longestValidParentheses(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') list.addLast(c);
            else if (c == ')') {
                if (list.size() == 0) {
                    list.addLast(')');
                    continue;
                }
                for (int j = list.size() - 1; j >= -1; j--) {
                    if (j == -1) {
                        list.addLast(')');
                        break;
                    }
                    char tmp = list.get(j);
                    if (tmp == '(') {
                        list.remove(j);
                        list.addLast('2');
                        break;
                    } else if (tmp == '2') {
                        continue;
                    } else {
                        list.addLast(')');
                        break;
                    }
                }
            }
        }
        int result = 0;
        Iterator<Character> itr = list.iterator();
        while (itr.hasNext()) {
            int tmp = 0;
            while (itr.hasNext() && itr.next() == '2') {
                tmp += 2;
            }
            result = Math.max(tmp, result);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(()))())(";
        longestValidParentheses(s);
    }
}
