import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class P236LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> way1 = new ArrayDeque<>();
        Deque<TreeNode> way2 = new ArrayDeque<>();
        findWay(root, p, way1);
        findWay(root, q, way2);
        TreeNode result = null;
        while(!way1.isEmpty() && !way2.isEmpty()) {
            if(way1.peek() == way2.poll()) result = way1.poll();
            else break;
        }
        return result;
    }

    public static void findWay(TreeNode root, TreeNode p, Deque<TreeNode> way) {
        if (Objects.isNull(root)) return;
        else if(!way.isEmpty() && way.peek().val == p.val) return;
        way.offer(root);
        if (root.val == p.val) {
            return;
        } else {
            if (root.left != null) {
                findWay(root.left, p, way);
                if(!way.isEmpty() && way.peekLast().val == p.val) return;
                way.pollLast();
            }
            if (root.right != null) {
                findWay(root.right, p, way);
                if(!way.isEmpty() && way.peekLast().val == p.val) return;
                way.pollLast();
            }
        }
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (Objects.isNull(root) || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (Objects.nonNull(left) && Objects.nonNull(right)) {
                return root;
            }
            return Objects.isNull(left) ? right : left;
        }
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("3,5,1,6,2,0,8,null,null,7,4");
        Util.printTree(tn);
        lowestCommonAncestor(tn, tn.left, tn.left.right.right);
    }
}
