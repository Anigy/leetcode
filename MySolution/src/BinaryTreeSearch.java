import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeSearch {

    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> inOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    public static List<Integer> preOrderRecursive(TreeNode n) {
        if (n == null)
            return preOrderList;
        preOrderList.add(n.val);
        preOrderRecursive(n.left);
        preOrderRecursive(n.right);
        return preOrderList;
    }

    public static List<Integer> preOrderIteration(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = n;
        Deque<TreeNode> queue = new ArrayDeque<>();
        while (cur != null || !queue.isEmpty()) {
            if (cur != null) {
                queue.offerFirst(cur);
                result.add(cur.val);
                cur = cur.left;
            } else {
                cur = queue.pollFirst();
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> inOrderRecursive(TreeNode n) {
        if (n == null)
            return inOrderList;
        inOrderRecursive(n.left);
        inOrderList.add(n.val);
        inOrderRecursive(n.right);
        return inOrderList;
    }

    public static List<Integer> inOrderIteration(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        if (n == null) {
            return result;
        }
        TreeNode cur = n;
        Deque<TreeNode> queue = new ArrayDeque<>();
        while (cur != null || !queue.isEmpty()) {
            if (cur != null) {
                queue.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = queue.pollFirst();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> postOrderRecursive(TreeNode n) {
        if (n == null)
            return postOrderList;
        postOrderRecursive(n.left);
        postOrderRecursive(n.right);
        postOrderList.add(n.val);
        return postOrderList;
    }

    public static List<Integer> postOrderIteration(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        if (n == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur = n;
        TreeNode visited = n;
        while (cur != null) {
            queue.offerFirst(cur);
            cur = cur.left;
        }
        while (!queue.isEmpty()) {
            cur = queue.pollFirst();
            if (cur.right != null && visited != cur.right) {
                queue.offerFirst(cur);
                cur = cur.right;
                while (cur != null) {
                    queue.offerFirst(cur);
                    cur = cur.left;
                }
            } else {
                visited = cur;
                result.add(cur.val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = Util.createTree("1,2,3,4,5,6,7,8,9,#,10,#,#,11,#");
        preOrderRecursive(t);
        inOrderRecursive(t);
        postOrderRecursive(t);
        List<Integer> preOrderIterationList = preOrderIteration(t);
        List<Integer> inOrderIterationList = inOrderIteration(t);
        List<Integer> postOrderIterationList = postOrderIteration(t);
        System.out.println("Pre-Order recursive result is  : " + preOrderList);
        System.out.println("Pre-Order iteration result is  : " + preOrderIterationList);
        System.out.println("In-Order recursive result is   : " + inOrderList);
        System.out.println("In-Order iteration result is   : " + inOrderIterationList);
        System.out.println("Post-Order recursive result is : " + postOrderList);
        System.out.println("Post-Order iteration result is : " + postOrderIterationList);
    }
}
