package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by bobi on 2018/9/9.
 */
public class Buchongfuzichuan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c) && map.get(c) >= start) {
                count = i - map.get(c);
                start = map.get(c) + 1;
            }
            else {
                count++;
                max = Math.max(count, max);
            }
            map.put(c, i);

        }
        System.out.println(max);
    }
}
