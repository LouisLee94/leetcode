package exam;

import java.util.Scanner;

/**
 * Created by bobi on 2018/9/8.
 */
public class Evolute {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        int[] scores = new int[m];

        for (int i = 0; i < n; i++) {
            scores[x[i]-1] = scores[x[i]-1] + 1;
        }

        if (success(scores)) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            backTrack(i, x, y, scores,0);
        }

        System.out.println(min);
    }

    private static void backTrack(int start, int[] x, int[] y, int[] scores, int count) {
        if (x[start] == 1) return;
        int temp = x[start];
        //改变投票
        x[start] = 1;
        count += y[start];
        scores[temp-1] = scores[temp-1] - 1;
        scores[0] += 1;

        if (success(scores)) {
            min = Math.min(min, count);
        } else {
            for(int i = start + 1; i < x.length; i++) {
                backTrack(i, x, y, scores, count);
            }
        }


        //撤销
        x[start] = temp;
        scores[x[start]-1] = scores[x[start]-1] + 1;
        scores[0] -= 1;

    }

    private static boolean success(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] >= max) return false;
        }
        return true;
    }
}
