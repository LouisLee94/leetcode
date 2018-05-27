import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String word: wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        for (String word: wordDict) {
            int len = word.length() * 2;
            String temp = word;
            while (len <= maxLength) {
                temp = temp + word;
                set.remove(temp);
                len += word.length();
            }
        }
        maxLength = 0;
        for (String word: set) {
            maxLength = Math.max(maxLength, word.length());
        }

        return helper(s, 0, set, maxLength);
    }

    private boolean helper(String s, int start, HashSet<String> set, int max) {
        if (start == s.length()) return true;
        for (int i = start + 1; i <= s.length() && i <= start + max; i++) {
            String sub = s.substring(start, i);
            if (set.contains(sub)) {
                if (helper(s, i, set, max)) return true;
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            int j = i - 1;
            while (j >= 0) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                j--;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        boolean r = new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList(new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
        System.out.println(r);
    }
}
