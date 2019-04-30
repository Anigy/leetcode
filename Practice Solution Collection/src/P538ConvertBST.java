import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P538ConvertBST {
    public static TreeNode convertBST(TreeNode root) {
        List<TreeNode> trees = new ArrayList<>();
        dfs(root, trees);
        int tmp = 0;
        for(TreeNode t : trees) {
            t.val += tmp;
            tmp = t.val;
        }
        return root;
    }

    public static void dfs(TreeNode node, List<TreeNode> trees) {
        if(Objects.isNull(node)) {
            return;
        }
        if(Objects.nonNull(node.right)) dfs(node.right, trees);
        trees.add(node);
        if(Objects.nonNull(node.left)) dfs(node.left, trees);
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("5,2,13");
        Util.printTree(convertBST(tn));
    }
}
