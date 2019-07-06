import java.util.Stack;

/**
 * @Classname P20IsValid
 * @Description TODO
 * @Date 2019/6/10 8:22
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P20IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char tmp = stack.pop();
                if (c == ')' && tmp == '(' || c == ']' && tmp == '[' || c == '}' && tmp == '{') continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
