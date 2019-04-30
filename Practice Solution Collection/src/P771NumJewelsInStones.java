import java.util.ArrayList;
import java.util.List;

public class P771NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        List<Character> chars = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            chars.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (chars.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
