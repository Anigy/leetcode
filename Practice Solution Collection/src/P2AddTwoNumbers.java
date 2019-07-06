/**
 * @Classname P2AddTwoNumbers
 * @Description TODO
 * @Date 2019/6/24 23:34
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        while (l1 != null || l2 != null) {
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;
            int tmp = m + n + carry;
            if (tmp > 10) {
                carry = 1;
                pointer.next = new ListNode(tmp - 10);
            } else {
                carry = 0;
                pointer.next = new ListNode(tmp);
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            pointer = pointer.next;
        }
        if(carry == 1) pointer.next = new ListNode(1);
        return result.next;
    }
}
