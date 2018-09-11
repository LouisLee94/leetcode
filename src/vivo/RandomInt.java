package vivo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by bobi on 2018/9/10.
 */
public class RandomInt {

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        for(int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(100000000);
        }

        for (int i = 0; i < 10; i++) {
            nums[i] = reverse(nums[i]);
        }
        Arrays.sort(nums);
    }

    private static int reverse(int i) {
        int res = 0;
        while (i > 0) {
            res = i%10 + res * 10;
            i /= 10;
        }
        return res;
    }
}
