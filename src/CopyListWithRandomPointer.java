import java.util.ArrayList;

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode node = head;
        while (node != null) {
            RandomListNode temp = new RandomListNode(node.label);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node = head;
        RandomListNode res = head.next;
        ArrayList<RandomListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            RandomListNode temp = node.next.next;
            node.next.random = node.random == null ? null : node.random.next;
            node.next.next = node.next.next == null ? null : node.next.next.next;
            node = temp;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i+1);
        }
        list.get(list.size()-1).next = null;
        return res;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        new CopyListWithRandomPointer().copyRandomList(node);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}