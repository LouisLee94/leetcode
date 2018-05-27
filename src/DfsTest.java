public class DfsTest {
    static int count = 0;

    private void dfs(int sum, int limit) {
        if (limit <= 1) {
            if (sum + 1 == 8) {
                count++;
            } else if (sum + 1 < 8) {
                dfs(sum + 1, 1);
            }
        }

        if (limit <= 2) {
            if (sum + 2 == 8) {
                count++;
            } else if (sum + 2 < 8) {
                dfs(sum + 2, 2);
            } else return;
        }

        if (limit <= 3) {
            if (sum + 3 == 8) {
                count++;
            } else if (sum + 3 < 8)
                dfs(sum+3, 3);
            else return;
        }

        if (limit <= 4) {
            if (sum + 4 == 8) {
                count++;
            } else if (sum + 4 < 8)
                dfs(sum+4, 4);
            else return;
        }


    }

    public static void main(String[] args) {
        new DfsTest().dfs(0, 0);
        int a = count;
    }
}
