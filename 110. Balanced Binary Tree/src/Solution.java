import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class Solution {
    public static boolean isBalanced(TreeNode root) {
        if(Objects.isNull(root)) {
            return true;
        }
        int l = dfs(root.left) + 1;
        int r = dfs(root.right) + 1;
        return Math.abs(l - r) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int dfs(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int l = dfs(root.left) + 1;
        int r = dfs(root.right) + 1;
        return Math.max(l, r);
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("1,2,2,3,3,null,null,4,4");
        Util.printTree(tn);
        System.out.println(isBalanced(tn));
    }
}

