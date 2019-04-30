import java.util.Objects;
import java.util.Stack;

public class P394DecodeString {
    public static String decodeString(String s) {
        char[] charArray = s.toCharArray();
        int pointer = 0;
        Stack<String> bucket = new Stack<>();
        StringBuilder result = new StringBuilder();
        while (pointer < charArray.length) {
            char c = charArray[pointer];
            if (c == '[') {
                bucket.push("[");
                pointer++;
                continue;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                StringBuffer tempSb = new StringBuffer();
                while (pointer < charArray.length &&
                        ((charArray[pointer] >= 'a' && charArray[pointer] <= 'z') ||
                                (charArray[pointer] >= 'A' && charArray[pointer] <= 'Z'))) {
                    tempSb.append(charArray[pointer++]);
                }
                bucket.push(tempSb.toString());
            } else if (c >= '0' && c <= '9') {
                StringBuffer tempSb = new StringBuffer();
                while (pointer < charArray.length &&
                        (charArray[pointer] >= '0' && charArray[pointer] <= '9')) {
                    tempSb.append(charArray[pointer++]);
                }
                bucket.push(tempSb.toString());
            } else if (c == ']') {
                pointer++;
                StringBuilder tsb = new StringBuilder();
                while (!bucket.isEmpty()) {
                    String curStr = bucket.pop();
                    char judgeC = curStr.charAt(0);
                    if (judgeC == '[') {
                        String countStr = bucket.pop();
                        int count = 0;
                        for (int i = 0; i < countStr.length(); i++) {
                            count = count * 10 + countStr.charAt(i) - '0';
                        }
                        String tmp = tsb.toString();
                        for (int j = 1; j < count; j++) {
                            tsb.append(tmp);
                        }
                        break;
                    } else if (judgeC >= '0' && judgeC <= '9') {
                        int count = 0;
                        for (int i = 0; i < curStr.length(); i++) {
                            count += count * 10 + curStr.charAt(i) - '0';
                        }
                        String tmp = tsb.toString();
                        for (int j = 1; j < count; j++) {
                            tsb.append(tmp);
                        }
                    } else {
                        tsb.insert(0, curStr);
                    }
                }
                bucket.push(tsb.toString());
            }
        }
        while (!bucket.isEmpty()) {
            String curStr = bucket.pop();
            result.insert(0, curStr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodeString(s).length());
    }
}
