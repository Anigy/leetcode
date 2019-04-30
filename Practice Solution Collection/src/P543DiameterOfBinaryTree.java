import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class P543DiameterOfBinaryTree {
    public static class Node {
        int leftDep;
        int rightDep;
        int len;
        Node() {
            this.leftDep = 0;
            this.rightDep = 0;
            this.len = 0;
        }
        int getDep() {
            return Math.max(this.leftDep, this.rightDep);
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Node> map = new HashMap<>();
        dfs(root, map);
        int result = 0;
        for(Map.Entry<TreeNode, Node> e : map.entrySet()) {
            result = Math.max(result, e.getValue().len);
        }
        return result;
    }

    public static void dfs(TreeNode root, Map<TreeNode, Node> map) {
        if(Objects.isNull(root)) return;
        if(Objects.nonNull(root.left)) dfs(root.left, map);
        if(Objects.nonNull(root.right)) dfs(root.right, map);
        Node n = new Node();
        TreeNode l = root.left;
        TreeNode r = root.right;
        n.leftDep =  Objects.isNull(l) ? 1 : map.get(l).getDep() + 1;
        n.rightDep = Objects.isNull(r) ? 1 : map.get(r).getDep() + 1;
        n.len = n.leftDep + n.rightDep - 2;
        map.put(root, n);
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("1,2,3,4,5");
        System.out.println(diameterOfBinaryTree(tn));
    }
}
