import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String >> lists = new ArrayList<>();
        Map<HashMap<Character, Integer>, Integer> map = new HashMap<>();
        for (String s: strs) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (char c: s.toCharArray()) {
                if (tempMap.containsKey(c)) tempMap.put(c, tempMap.get(c)+1);
                else tempMap.put(c, 1);
            }
            if (map.containsKey(tempMap)) lists.get(map.get(tempMap)).add(s);
            else {
                map.put(tempMap, lists.size());
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                lists.add(tempList);
            }
        }
        return lists;
    }
}
