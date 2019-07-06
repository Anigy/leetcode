/**
 * @Classname P19RemoveNthFromEnd
 * @Description TODO
 * @Date 2019/6/10 8:53
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P19RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode re = new ListNode(0);
        re.next = head;
        ListNode tmp = re;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            if(fast != null) fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
            tmp = tmp.next;
        }
        tmp.next = slow.next;
        slow.next = null;
        return re.next;
    }
}
