package exam;

import java.util.Arrays;
import java.util.Scanner;

public class CrazyQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }

        int ans = 0;
        int[] result = new int[n];

        if (n == 1) {
            System.out.print(0);
            return;
        }
        if (n == 2) {
            System.out.print(Math.abs(h[0]-h[1]));
            return;
        }
        Arrays.sort(h);
        int flag = 1;
        int start = n/2;
        int smaller = 0, larger = n - 1;
        int hp;
        for (int i = 0; i < n; i++) {
            int shift = (i+1)/2*flag;

            if (i % 2 == 0) hp = smaller++;
            else hp = larger--;

            result[start + shift] = h[hp];

            flag *= -1;
        }

        for (int i = 1; i < n; i++) {
            ans += Math.abs(result[i] - result[i-1]);
        }

        flag = 1;
        start = n/2;
        smaller = 0; larger = n - 1;
        for (int i = 0; i < n; i++) {
            int shift = (i+1)/2*flag;

            if (i % 2 == 0) hp = larger--;
            else hp = smaller++;

            result[start + shift] = h[hp];

            flag *= -1;
        }
        int ans2 = 0;
        for (int i = 1; i < n; i++) {
            ans2 += Math.abs(result[i] - result[i-1]);
        }

        System.out.print(Math.max(ans, ans2));
    }
}
