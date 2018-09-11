package exam;

import java.util.Scanner;

public class FourBall {

    static int max = 0;
    static int m1, m2, m3, m4;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int n4 = in.nextInt();

        m1 = in.nextInt();
        m2 = in.nextInt();
        m3 = in.nextInt();
        m4 = in.nextInt();

        n = n1 + n2 + n3 + n4;
        int[] push = new int[n];

        backTrack(push, n1, n2, n3, n4);

        System.out.print(max);



    }

    static void backTrack(int[] push, int n1, int n2, int n3, int n4) {
        int remain = n1 + n2 + n3 + n4;
        if (remain == 0 ) {
            int sum = 0, weight = push[0];
            for (int i = 1; i < n; i++) {
                sum += push[i] * (weight % 10);
                weight += push[i];
            }
            max = Math.max(sum, max);
        } else {
            if (n1 != 0) {
                push[n - remain] = m1;
                backTrack(push, n1-1, n2, n3, n4);
                push[n - remain] = 0;
            }
            if (n2 != 0) {
                push[n - remain] = m2;
                backTrack(push, n1, n2-1, n3, n4);
                push[n - remain] = 0;
            }
            if (n3 != 0) {
                push[n - remain] = m3;
                backTrack(push, n1, n2, n3-1, n4);
                push[n - remain] = 0;
            }
            if (n4 != 0) {
                push[n - remain] = m4;
                backTrack(push, n1, n2, n3, n4-1);
                push[n - remain] = 0;
            }
        }
    }
}
