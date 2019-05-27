public class P160GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int longA = 0;
        int longB = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null) {
            longA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            longB++;
            tmpB = tmpB.next;
        }
        tmpA = headA;
        tmpB = headB;
        if (longA > longB) {
            for (int i = 0; i < longA - longB; i++) {
                tmpA = tmpA.next;
            }
        } else {
            for (int i = 0; i < longB - longA; i++) {
                tmpB = tmpB.next;
            }
        }
        while (tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return tmpA;
    }
}
