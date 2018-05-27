import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        ArrayList<List<String>> [] result = new ArrayList[s.length()+1];
        result[0] = lists;

        for (int i = 1; i <= s.length(); i++) {
            result[i] = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                String sub = s.substring(j, i);
                if (isPalindrome(sub)) {
                    ArrayList<ArrayList<String>> strList = new ArrayList<>();
                    for (List<String> list : result[j]) {
                        strList.add((ArrayList<String>)((ArrayList<String>)list).clone());
                    }
                    for (List<String> strs: strList) {
                        strs.add(sub);
                    }
                    result[i].addAll(strList);
                }
            }
        }
        return result[s.length()];
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
    }
}
