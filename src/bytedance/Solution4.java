package bytedance;

import java.util.Scanner;

/**
 * Created by bobi on 2018/9/9.
 */
public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (!(((arr[i] >> 7) & 1) == 0)) {
                int len = 1;
                int j = 6;
                while (((arr[i] >> j) & 1) == 1) {
                    if(!startWith10(arr[i+len])) {
                        System.out.println(0);
                        return;
                    }
                    len++;
                    j--;
                    if (len > 4) {
                        System.out.println(0);
                        return;
                    }
                }
                if (len == 1) {
                    System.out.println(0);
                    return;
                }
                i += len;

            }
        }
        System.out.println(1);
    }

    private static boolean startWith10(int n) {
        if(((n>>7) & 1) == 1 && ((n>>6) & 1) == 0) return true;
        return false;
    }
}
