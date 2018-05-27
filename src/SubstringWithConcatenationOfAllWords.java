import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0 || words[0] == null || words[0].equals("")) return null;
        int wordLen = words[0].length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length()-wordLen*words.length+1; i++) {
            String substr = s.substring(i, i+wordLen);
            for (int j = 0; j < words.length; j++) {
                boolean isMatch = true;
                if (words[j].equals(substr)) {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(j);
                    for (int k = 1; k < words.length; k++) {
                        String substr_temp = s.substring(i+k*wordLen, i+(k+1)*wordLen);
                        int l;
                        for (l = 0; l < words.length; l++) {
                            if (substr_temp.equals(words[l])) {
                                if (!set.contains(l)) {
                                    set.add(l);
                                    break;
                                }
                            }
                        }
                        if (l == words.length) {  //说明words中没有匹配的
                            isMatch = false;
                            break;
                        }
                    }
//                    if (!isMatch) break;
//                    list.add(i);
                    if (isMatch) list.add(i);
                    break;
                }

            }
        }
        return list;
    }
    public static void main(String [] args) {
        String[] words = new String[]{"foo","bar"};
        List<Integer> list = new SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman", words);
    }
}
