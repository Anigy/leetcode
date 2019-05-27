import java.util.*;

public class P297Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (Objects.isNull(root)) {
            return "";
        } else {
            queue.offer(root);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new ArrayDeque<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.val == Integer.MAX_VALUE) {
                    sb.append("null,");
                } else {
                    sb.append(node.val + ",");
                    tmp.offer(Objects.isNull(node.left) ? new TreeNode(Integer.MAX_VALUE) : node.left);
                    tmp.offer(Objects.isNull(node.right) ? new TreeNode(Integer.MAX_VALUE) : node.right);
                }
            }
            for (TreeNode n : tmp) {
                if (n.val != Integer.MAX_VALUE) {
                    queue.addAll(tmp);
                    break;
                }
            }
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (Objects.isNull(data) || data.length() == 0) return null;
        String[] cs = data.split(",");
        TreeNode root = new TreeNode(stringToInt(cs[0]));
        List<TreeNode> container = new ArrayList<>();
        container.add(root);
        for (int i = 1; i < cs.length; i++) {
            String s = cs[i];
            if (s.equals("null")) continue;
            int p = (i - 1) / 2;
            TreeNode n = new TreeNode(stringToInt(cs[i]));
            container.add(n);
            TreeNode parent = container.get(p);
            if ((i - 1) % 2 == 0) {
                parent.left = n;
            } else parent.right = n;
        }
        return root;
    }

    public static int stringToInt(String s) {
        if (s.length() <= 0) return 0;
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(0) == '-') flag = true;
            else
                result = result * 10 + s.charAt(i) - '0';
        }
        return flag ? 0 - result : result;
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("0,1,null,2,null,3,null,4,null");
        Util.printTree(tn);
        String result = serialize(tn);
        System.out.println(result);
        TreeNode t = deserialize(result);
        Util.printTree(t);
    }
}
