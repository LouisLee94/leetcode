public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int countA = 1, countB = 1;
        ListNode tailA = headA, tailB = headB;
        while (tailA.next != null) {
            countA++;
            tailA = tailA.next;
        }
        while (tailB.next != null) {
            countB++;
            tailB = tailB.next;
        }
        if (tailA != tailB) return null;
        int dif = countA - countB;
        if (dif < 0) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            dif = -dif;
        }
        for (int i = 0; i < dif; i++) {
            headA = headA.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {val = x;next = null;}
    }
}
