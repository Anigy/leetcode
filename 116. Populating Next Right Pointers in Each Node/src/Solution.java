import java.util.LinkedList;
import java.util.Objects;

public class Solution {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(0);
        connect(node);
    }

    public static void connect(TreeLinkNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        LinkedList<TreeLinkNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while (linkedList.size() > 0) {
            LinkedList<TreeLinkNode> tmp = new LinkedList<>();
            for (int i = 0; i < linkedList.size(); i++) {
                TreeLinkNode node = linkedList.get(i);
                if (i == linkedList.size() - 1) {
                    node.next = null;
                } else {
                    TreeLinkNode nextNode = linkedList.get(i + 1);
                    node.next = nextNode;
                }
                if (Objects.nonNull(node.left)) {
                    tmp.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    tmp.addLast(node.right);
                }
            }
            linkedList.clear();
            linkedList.addAll(tmp);
        }
    }
}
