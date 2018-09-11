package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bobi on 2018/8/25.
 */
public class PM2dot5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println();findMaxLen(arr, t);
    }

    private static int findMaxLen(int[] arr, int t) {
        List<Integer> dp = new ArrayList<>();
        dp.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= dp.get(dp.size()-1)) dp.add(arr[i]);
            else {
                for (int j = 0; j < dp.size(); j++) {
                    if (dp.get(j) > arr[i]) dp.set(j, arr[j]);
                }
            }
        }
        return dp.size();
    }
}
