import java.util.Scanner;

/**
 * Created by bobi on 2018/9/8.
 */
public class BuyHouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            findMinAndMax(n, k);
        }


    }

    private static void findMinAndMax(int n, int k) {
        int max;
        if (n <= 2) max = 0;
        else if (k > n - k) max = n - k;
        else  max = k - 1;
        System.out.println("0 " + max);
    }
}
