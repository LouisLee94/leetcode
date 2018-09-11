package exam;

import java.util.Scanner;

public class ZerosOnes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        int count = 0, max = 0;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i-1)) {
                count++;
                if (count == input.length() - 1) {
                    max = input.length();
                }
            } else {
                max = Math.max(max, ++count);
                count = 0;
            }
        }

        System.out.print(max);
    }
}
