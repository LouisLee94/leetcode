import java.util.*;

public class LRUCache {

    Map<Integer, Integer> map;

    LinkedList<Integer> queue;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove((Integer)key);
            queue.offer(key);
            return map.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove((Integer)key);
            queue.offer(key);
        } else if (queue.size() == capacity) {
            int least = queue.poll();
            map.remove(least);
            queue.offer(key);
        } else {
            queue.offer(key);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
