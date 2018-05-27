import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(set, list, s, 0, sb);
        return list;
    }

    private void helper(Set<String> set, List<String> list, String s, int start, StringBuilder sb) {
        if(start == s.length()) {
            list.add(sb.toString().trim());
            return;
        }
        for (int i = start+1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (set.contains(sub)) {
                sb.append(" ");
                sb.append(sub);
                helper(set, list, s, i, sb);
                sb.delete(sb.lastIndexOf(" "), sb.length());
            }
        }
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        List<String> [] lists = new List[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 0; i < s.length(); i++) {
            lists[i] = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                String sub = s.substring(j, i+1);
                if ((j==0||!lists[j-1].isEmpty()) && set.contains(sub)) {
                    if (j == 0) lists[i].add(sub);
                    else {
                        for (String str: lists[j-1]) {
                            lists[i].add(str+ " " + sub);
                        }
                    }
                }
            }
        }
        return lists[s.length()-1];
    }
}
