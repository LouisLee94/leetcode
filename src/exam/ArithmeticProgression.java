package exam;

import java.util.Arrays;
import java.util.Scanner;

public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        if (len <= 2) {
            System.out.print("Possible");
            return;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for (int i = 1; i < len - 1; i++) {
            if (arr[i+1] - arr[i] != dif) {
                System.out.print("Impossible");
                return;
            }
        }
        System.out.print("Possible");

    }
}
