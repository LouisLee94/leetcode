/**
 * Created by bobi on 2018/9/6.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
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

    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if (i-1>=0 && grid[i-1][j]=='1') dfs(grid, i-1, j);
        if (j-1>=0 && grid[i][j-1]=='1') dfs(grid, i, j-1);
        if (i+1<grid.length && grid[i+1][j]=='1') dfs(grid, i+1, j);
        if (j+1<grid[0].length && grid[i][j+1]=='1') dfs(grid, i, j+1);
    }
}
