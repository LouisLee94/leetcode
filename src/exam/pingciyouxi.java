import java.util.*;

public class pingciyouxi {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        Map<Integer, TreeSet<Character>> map = new TreeMap<>();
        int N = in.nextInt();
        int L = in.nextInt();
        for (int i = 0; i < N; i++) {
            String t = in.next();
            set.add(t);
            for (int j = 0; j < L; j++) {
                if (map.containsKey(j + 1)) {
                    map.get(j + 1).add(t.charAt(j));
                } else {
                    TreeSet<Character> treeSet = new TreeSet<>();
                    treeSet.add(t.charAt(j));
                    map.put(j + 1, treeSet);
                }
            }
        }
        TreeMap<Integer, ArrayList<Character>> charsMap = new TreeMap<>();
        for (int i = 0; i < L; i++) {
            ArrayList<Character> list = new ArrayList<>(map.get(i + 1));
            charsMap.put(i + 1, list);
        }
        if (!next(set, charsMap, new StringBuilder(""), L, 1)) {
            System.out.println("-");
        }

    }

    private static boolean next(HashSet<String> set, TreeMap<Integer, ArrayList<Character>> charsMap, StringBuilder stringBuilder, int L, int l) {
        for (int i = 0; i < charsMap.get(l).size(); i++) {
            stringBuilder.append(charsMap.get(l).get(i));
            if (l == L) {
                if (!set.contains(stringBuilder.toString())) {
                    System.out.println(stringBuilder.toString());
                    return true;
                }
            } else {
                StringBuilder sb = new StringBuilder(stringBuilder);
                if (next(set, charsMap, sb, L, l + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}