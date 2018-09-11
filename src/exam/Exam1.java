package exam;

import java.util.Scanner;

public class Exam1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x1 = new int[n], y1 = new int[n], x2 = new int[n], y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextInt();
        }
        int minX1 = Integer.MAX_VALUE, minY1 = Integer.MAX_VALUE, maxX2 = Integer.MIN_VALUE, maxY2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minX1 = Math.min(x1[i], minX1);
            minY1 = Math.min(y1[i], minY1);
            maxX2 = Math.max(x2[i], maxX2);
            maxY2 = Math.max(y2[i], maxY2);
        }
        int result = 1;
        for (int i = minY1; i <= maxY2; i++) {
            for (int j = minX1; j <= maxX2; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if(j>x1[k]&&j<x2[k]&& i>y1[k] && i<y2[k]) {
                        count++;
                    }
                }
                result = Math.max(result, count);

            }
            if (result == n) break;
        }
        System.out.print(result);
    }
}
