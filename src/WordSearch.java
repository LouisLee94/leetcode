import com.sun.xml.internal.ws.util.StringUtils;

public class WordSearch {
    static boolean[][] isReached;
    static int m, n;
    static boolean isExist;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return word == null || word.isEmpty();
        m = board.length;
        n = board[0].length;
        isReached = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isReached[i][j] = true;
                    dfs(i, j , board, 0, word);
                    if (isExist) return true;
                    isReached[i][j] = false;
                }
            }
        }
        return false;
    }

    private void dfs(int i, int j, char[][] board, int k, String word) {

        if (k == word.length()-1) {
            isExist = true;
            return;
        }

        if (i - 1 >= 0 && !isReached[i-1][j] && word.charAt(k+1)==board[i-1][j]) {
            isReached[i-1][j] = true;
            dfs(i-1, j, board, k+1, word);
            if (isExist) return;
            isReached[i-1][j] = false;
        }
        if (i + 1 < m && !isReached[i+1][j] && word.charAt(k+1)==board[i+1][j]) {
            isReached[i+1][j] = true;
            dfs(i+1, j, board, k+1, word);
            if (isExist) return;
            isReached[i+1][j] = false;
        }
        if (j - 1 >= 0 && !isReached[i][j-1] && word.charAt(k+1)==board[i][j-1]) {
            isReached[i][j-1] = true;
            dfs(i, j-1, board, k+1, word);
            if (isExist) return;
            isReached[i][j-1] = false;
        }
        if (j + 1 < n && !isReached[i][j+1] && word.charAt(k+1)==board[i][j+1]) {
            isReached[i][j+1] = true;
            dfs(i, j+1, board, k+1, word);
            if (isExist) return;
            isReached[i][j+1] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
                //{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean result = new WordSearch().exist(board,"ab");
    }
}
