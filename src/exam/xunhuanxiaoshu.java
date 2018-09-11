package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by bobi on 2018/8/30.
 */
public class xunhuanxiaoshu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numerator = in.nextInt();
        int denominator = in.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        numerator %= denominator;
        if (numerator == 0) {
            System.out.println("0 0");
            return;
        }
        int point = 0;
        while (!map.containsKey(numerator)) {
            map.put(numerator, point++);
            numerator *= 10;
            numerator %= denominator;
            if (numerator == 0) {
                System.out.println((point)+ " " +0);
                return;
            }
        }
        System.out.println(map.get(numerator) + " " + (point - map.get(numerator)));

    }
}
