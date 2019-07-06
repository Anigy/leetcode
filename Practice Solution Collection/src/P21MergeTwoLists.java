/**
 * @Classname P21MergeTwoLists
 * @Description TODO
 * @Date 2019/6/10 7:53
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P21MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l2 == null || l1 == null) return l1 == null ? l2 : l1;
        ListNode re = new ListNode(0);
        ListNode pointer = re;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }
        if(l1 == null && l2 == null) return re.next;
        else if(l1 == null || l2 == null) {
            pointer.next = l1 == null ? l2 : l1;
            return re.next;
        }
        return re.next;
    }
}
