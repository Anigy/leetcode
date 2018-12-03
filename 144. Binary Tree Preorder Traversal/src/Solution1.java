import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.tree.TreeNode;

public class Solution1 {
    /**
     * recursion
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
