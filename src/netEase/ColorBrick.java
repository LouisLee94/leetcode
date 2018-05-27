package netEase;

import java.util.Scanner;

public class ColorBrick {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] count = new int[26];
        for (char c : input.toCharArray()) {
            count[c - 'A']++;
        }
        int kinds = 0;
        for (int i : count) {
            if (i != 0) kinds += 1;
        }
        int result = 0;
        if (kinds == 1) result = 1;
        else if (kinds == 2) result = 2;

        System.out.print(result);
    }

    
}
