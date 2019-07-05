import java.util.*;

public class OfferFindPath {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return result;
        find(root, target, new ArrayList<>());
        return result;
    }

    public static void find(TreeNode n, int target, ArrayList<Integer> list) {
        if (n == null)
            return;
        list.add(n.val);
        if (n.left == null && n.right == null && n.val == target) {
            result.add(new ArrayList<>(list));
        }
//        if(n.left != null) find(n.left, target - n.val, new ArrayList(list));
//        if(n.right != null) find(n.right, target - n.val, new ArrayList(list));

        if(n.left != null) find(n.left, target - n.val, list);
        if(n.right != null) find(n.right, target - n.val, list);
        list.remove(list.size() - 1);
    }

    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath1(root.left, target);
        FindPath1(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

    public static void main(String[] args) {
        TreeNode t = Util.createTree("1,2,3,7,6,7,3,1,2,#,2,#,#,4,#");
        ArrayList<ArrayList<Integer>> re = FindPath(t, 11);
        System.out.println("Hello World!");
    }

}