import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.') continue;
                if (set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i]=='.') continue;
                if (set.contains(board[j][i])) return false;
                else set.add(board[j][i]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i*3+k][j*3+l]=='.') continue;
                        if (set.contains(board[i*3+k][j*3+l])) return false;
                        else set.add(board[i*3+k][j*3+l]);
                    }
                }
            }
        }
        return true;
    }
}
