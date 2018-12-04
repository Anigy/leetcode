import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(Objects.nonNull(currentNode) || !stack.empty()) {
            if(Objects.nonNull(currentNode)) {
                stack.push(currentNode);
                currentNode = currentNode.left;
                continue;
            } else {
                currentNode =  stack.pop();
                res.add(currentNode.val);
                currentNode = currentNode.right;
                continue;
            }
        }
        return res;
    }
}