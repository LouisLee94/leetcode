package bytedance;

import java.util.*;


public class Solution2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        char[][] input = new char[M][M];
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                input[i][j] = scanner.next().charAt(0);
            }
        }
        System.out.println(numIslands(input));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if (i-1>=0 && grid[i-1][j]=='1') dfs(grid, i-1, j);
        if (j-1>=0 && grid[i][j-1]=='1') dfs(grid, i, j-1);
        if (i+1<grid.length && grid[i+1][j]=='1') dfs(grid, i+1, j);
        if (j+1<grid[0].length && grid[i][j+1]=='1') dfs(grid, i, j+1);
    }
}

