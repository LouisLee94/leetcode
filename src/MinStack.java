import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinStack {

    PriorityQueue<Integer> queue;
    ArrayList<Integer> list;

    public MinStack() {
        super();
        queue = new PriorityQueue<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
        queue.add(x);
    }

    public void pop() {
        int x = top();
        list.remove(list.size()-1);
        queue.remove(x);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return queue.peek();
    }
}
