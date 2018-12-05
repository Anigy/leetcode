import javafx.util.Pair;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Pair<TreeNode, int[]> result = build(inorder, postorder);
        return result.getKey();
    }

    private Pair<TreeNode, int[]> build(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return new Pair(null, postorder);
        }
        int val = postorder[postorder.length - 1];
        TreeNode newTreeNode = new TreeNode(val);
        postorder = Arrays.copyOfRange(postorder, 0, postorder.length-1);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        Pair<TreeNode, int[]> p = build(rightIn, postorder);
        newTreeNode.right = p.getKey();
        postorder = p.getValue();
        p = build(leftIn, postorder);
        newTreeNode.left = p.getKey();
        postorder = p.getValue();
        return new Pair(newTreeNode, postorder);
    }
}
