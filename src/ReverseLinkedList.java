import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobi on 2018/9/8.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        node = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            node.val = list.get(i);
            node = node.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static void main(String[] args) {
        ListNode l1,l2,l3,l4,l5;
        l1 = new ListNode(1);
        l2 = new ListNode(2);
        l3 = new ListNode(3);
        l4 = new ListNode(4);
        l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new ReverseLinkedList().reverseList(l1);
    }
}
