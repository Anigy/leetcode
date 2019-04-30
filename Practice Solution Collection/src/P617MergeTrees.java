import java.util.Objects;

public class P617MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(Objects.isNull(t1) && Objects.isNull(t2)){
            return null;
        }
        if(Objects.isNull(t1)) {
            return t2;
        } else if(Objects.isNull(t2)) {
            return t1;
        } else {
            int val = t1.val + t2.val;
            TreeNode node = new TreeNode(val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
            return node;
        }
    }
}
