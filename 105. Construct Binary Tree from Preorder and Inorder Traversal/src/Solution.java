import javafx.util.Pair;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder).getKey();
    }

    private Pair<TreeNode, int[]> build(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return new Pair(null, preorder);
        }
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        int[] pre = Arrays.copyOfRange(preorder, 1, preorder.length);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        // no need to compare index+1 with inorder.length, max index can be inorder.length, and then int[] is null
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        Pair<TreeNode, int[]> p = build(pre, leftIn);
        root.left = p.getKey();
        pre = p.getValue();
        p = build(pre, rightIn);
        root.right = p.getKey();
        return new Pair(root, p.getValue());
    }
}
