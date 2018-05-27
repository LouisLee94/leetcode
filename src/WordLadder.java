import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;
        LinkedList<String> list = new LinkedList<>();
        Set<String> set = new HashSet<>();
        list.add(beginWord);
        int result = 1;
        while (true) {
            result++;
            boolean isEnd = true;
            int len = list.size();
            for (int j = 0; j < len; j++) {
                beginWord = list.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    String word = wordList.get(i);
                    if (set.contains(word)) continue;
                    if (match(beginWord, word)) {
                        isEnd = false;
                        if (word.equals(endWord))
                            return result;
                        set.add(word);
                        i--;
                        list.offer(word);
                    }
                }

            }
            if (isEnd)
                return 0;

        }

    }

    private boolean match(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++count > 1) return false;
            }
        }
        return count == 1;
    }
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>(){{
            add("hot");
            add("hit");
            add("dog");
        //    add("lot");
          //  add("log");
            add("cog");
            add("dot");
        }};
                //Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        new WordLadder().ladderLength("hit", "cog", list);
    }
}
