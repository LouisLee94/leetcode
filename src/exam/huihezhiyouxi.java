package exam;

import java.util.Scanner;

/**
 * Created by bobi on 2018/8/30.
 */
public class huihezhiyouxi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int HP = in.nextInt();
        int normal = in.nextInt();
        int buffer = in.nextInt();
        int result = 0;
        if (2*normal >= buffer) {

            result = HP/normal + (HP%normal == 0 ? 0 : 1);

        } else {
            int temp = HP % buffer;
            int plus = 0;
            if (temp == 0) {
                plus = 0;
            } else if (temp <= normal) {
                plus = 1;
            } else if (temp > normal) {
                plus = 2;
            }
            result = 2 * HP / buffer + plus;
        }
        System.out.println(result);
    }
}
