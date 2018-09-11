package bytedance;

import java.util.Scanner;

/**
 * Created by bobi on 2018/9/9.
 */
public class Solution3 {
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        backTrack(str, 0);
        System.out.println(count);

    }

    private static void backTrack(String sub, int n) {

        int len = sub.length();

        if(n == 4) {
            if (len == 0) count++;
            return;
        }

        if (len == 0) return;

        if(sub.charAt(0) == '0') {
            backTrack(sub.substring(1), n+1);
            return;
        }

        for (int i = 1; i <= len; i++) {
            int temp = Integer.parseInt(sub.substring(0, i));
            if(temp >= 0 && temp < 256) {
                backTrack(sub.substring(i), n+1);
            } else return;
        }
    }
}
