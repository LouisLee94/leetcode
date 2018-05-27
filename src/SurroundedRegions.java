import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        if (m <= 2) return;
        int n = board[0].length;
        if (n <= 2) return;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(0, i, board);
            }
            if (board[m-1][i] == 'O') {
                bfs(m-1, i, board);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board);
            }
            if (board[i][n-1] == 'O') {
                bfs(i, n-1, board);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'B')
                    board[i][j] = 'O';

            }
        }

    }

    private void bfs(int row, int col, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<Integer> ver = new ArrayList<Integer>() {{
            add(row);
        }};
       List<Integer> hor = new ArrayList<Integer>() {{
           add(col);
       }};
        while (!hor.isEmpty()) {
            List<Integer> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            for (int k = 0; k < hor.size(); k++) {
                int i = ver.get(k), j = hor.get(k);
                board[i][j] = 'B';
                if (i-1>=0 && board[i-1][j] == 'O') {
                    temp1.add(i-1);
                    temp2.add(j);
                }
                if (i+1<m && board[i+1][j] == 'O') {
                    temp1.add(i+1);
                    temp2.add(j);
                }
                if (j-1>=0 && board[i][j-1] == 'O') {
                    temp1.add(i);
                    temp2.add(j-1);
                }
                if (j+1<n && board[i][j+1] == 'O') {
                    temp1.add(i);
                    temp2.add(j+1);
                }
            }
            ver = temp1;
            hor = temp2;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'},
        };

        new SurroundedRegions().solve(board);
    }
}
