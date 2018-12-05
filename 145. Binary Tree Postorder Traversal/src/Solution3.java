import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode popOne = stack.removeFirst();
            res.addFirst(popOne.val);
            if (Objects.nonNull(popOne.left)) {
                stack.addFirst(popOne.left);
            }
            if (Objects.nonNull(popOne.right)) {
                stack.addFirst(popOne.right);
            }
        }
        return res;
    }
}
