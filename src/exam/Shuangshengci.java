package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bobi on 2018/8/25.
 */
public class Shuangshengci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0 ; i < t; i++) {
            int n = in.nextInt();
            List<String> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(in.next());
            }
            isExist(list);
        }
    }

    private static void isExist(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(isWord(list.get(i), list.get(j))) {
                    System.out.println("Yeah");
                    return;
                }
            }
        }
        System.out.println("Sad");

    }

    private static boolean isWord(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        else {
            String temp = str1+str1;
            if (temp.contains(str2)) return true;
            else {
                String temp2 = inverse(str2);
                if (temp.contains(temp2)) return true;
            }
        }
        return false;
    }

    private static String inverse(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(arr.length - 1 - i);
        }
        return String.valueOf(arr);
    }
}
