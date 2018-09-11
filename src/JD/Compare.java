package JD;

import java.util.Scanner;

/**
 * Created by bobi on 2018/9/9.
 */
public class Compare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] as = new int[n];
        int[] bs = new int[n];
        int[] cs = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = in.nextInt();
            bs[i] = in.nextInt();
            cs[i] = in.nextInt();
        }
        boolean[] isUnqualified = new boolean[n];
        int count = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isUnqualified[j] && as[i] < as[j] && bs[i] < bs[j] && cs[i] < cs[j]) {
                    count++;
                    isUnqualified[i] = true;
                    break;
                }
            }
        }
        System.out.println(count);

    }
}
