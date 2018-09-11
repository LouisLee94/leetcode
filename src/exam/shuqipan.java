package exam;

import java.util.Scanner;

/**
 * Created by bobi on 2018/8/30.
 */
public class shuqipan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = in.next().toCharArray();
        }

        for (int i = 0; i < M; i++) {
            int count_o = 0;
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 'o') {
                    count_o++;
                    board[j][i] = '.';
                } else if (board[j][i] == 'x') {
                    for (int k = 0; k < count_o; k++) {
                        board[j-1-k][i] = 'o';
                    }
                    count_o = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(String.valueOf(board[i]));
        }
    }
}
