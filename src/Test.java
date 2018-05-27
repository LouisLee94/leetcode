import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Test {

    static class Node {
        int val;
    }

    private void test(Node n) {
        n = new Node();
        n.val = 1;
    }

    // 出现java.util.ConcurrentModificationException
    public List<String> m1(List<String> list) {
        for (String temp : list) {
            if ("3".equals(temp)) {
                list.remove(temp);
            }
        }
        return list;

    }
    // 出现java.util.ConcurrentModificationException
    public List<String> m2(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if ("3".equals(temp)) {
                list.remove(temp);
            }

        }
        return list;

    }
    //successful!
    public List<String> m3(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if ("1".equals(list.get(i))) {
                list.remove(i);

            }

        }
        return list;

    }


    public void doTwo(List<Integer> list){

    }
    public static void main(String[] args) {
        int n = -128;
        byte x = (byte) n;
    }
}
