import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> re = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode popOne = stack.pop();
            re.push(popOne);
            if (Objects.nonNull(popOne.left)) {
                stack.push(popOne.left);
            }
            if (Objects.nonNull(popOne.right)) {
                stack.push(popOne.right);
            }
        }
        while (!re.empty()) {
            res.add(re.pop().val);
        }
        return res;
    }
}
