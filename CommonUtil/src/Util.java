import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
public class Util {
    public static TreeNode createTree(String tree) {
        // {1,2,3,4,#,#,#,5,#,6,#,7,#,8}
        String[] ss = tree.split(",");
        return createTree(ss);
    }

    public static TreeNode createTree(String[] tree) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = constructOne(tree[0]);
        q.add(root);
        int idx = 1;
        while (!q.isEmpty()) {

            TreeNode tn = q.poll();
            if (tn == null) {
                continue;
            }
            if (idx == tree.length) {
                break;
            }
            TreeNode left_ = constructOne(tree[idx]);
            tn.left = left_;
            q.add(left_);
            idx++;
            if (idx == tree.length) {
                break;
            }
            TreeNode right_ = constructOne(tree[idx]);
            idx++;
            tn.right = right_;
            q.add(right_);
        }
        return root;
    }

    private static void printNode(TreeNode tn, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }
        sb.append(tn.val);
        System.out.println(sb.toString());
    }

    public static void printTree(TreeNode root, int indent) {
        if (root == null) {
            return;
        }
        printTree(root.right, indent + 1);
        printNode(root, indent);
        printTree(root.left, indent + 1);
    }

    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static TreeNode constructOne(String s) {
        if (s.compareTo("#") ==0 || s.compareTo("null") == 0) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }

    public static void main(String args[]) {
        TreeNode tn = createTree("2,#,3,#,4,#,5,#,6");
        printTree(tn);
    }
}

