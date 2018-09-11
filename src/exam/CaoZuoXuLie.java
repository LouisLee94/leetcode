package exam;

import java.util.Scanner;

public class CaoZuoXuLie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }

        int[] ans = new int[len];
        int first = len/2;
        int flag = -1;
        if (len % 2 == 0) flag = 1;
        for (int i = 0; i < len; i++) {

            int shift = (i + 1)/2*flag;
            flag *= -1;

            ans[first + shift] = arr[i];
        }

        for (int i = 0; i < len - 1; i++) {
            System.out.print(ans[i]+ " ");
        }
        System.out.print(ans[len - 1]);
    }

}
