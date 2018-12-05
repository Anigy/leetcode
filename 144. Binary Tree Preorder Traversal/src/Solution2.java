import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution2 {
    /**
     * non recursion
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode popOne = stack.pop();
            res.add(popOne.val);
            if (Objects.nonNull(popOne.right)) {
                stack.push(popOne.right);
            }
            if (Objects.nonNull(popOne.left)) {
                stack.push(popOne.left);
            }
        }
        return res;
    }
}
