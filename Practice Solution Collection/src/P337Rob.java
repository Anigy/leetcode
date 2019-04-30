import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class P337Rob {
    private static Map<TreeNode, Integer> inMap = new HashMap<>();
    private static Map<TreeNode, Integer> outMap = new HashMap<>();

    public static int rob(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        } else if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            inMap.put(root, root.val);
            outMap.put(root, 0);
            return root.val;
        }
        if (Objects.nonNull(root.left)) {
            rob(root.left);
        }
        if (Objects.nonNull(root.right)) {
            rob(root.right);
        }
        int inValue = root.val + outMap.getOrDefault(root.left, 0) + outMap.getOrDefault(root.right, 0);
        int outValue = Math.max(inMap.getOrDefault(root.left, 0), outMap.getOrDefault(root.left, 0))
                + Math.max(inMap.getOrDefault(root.right, 0), outMap.getOrDefault(root.right, 0));
        inMap.put(root, inValue);
        outMap.put(root, outValue);
        return Math.max(inValue, outValue);
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("3,2,3,null,3,null,1");
        Util.printTree(tn);
        int result = rob(tn);
        System.out.println(result);
    }
}
