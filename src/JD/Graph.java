package JD;

import java.util.Scanner;

/**
 * Created by bobi on 2018/9/9.
 */
public class Graph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] graph = new int[n][n];
            for (int j = 0; j < m; j++){
                int v1 = in.nextInt() - 1;
                int v2 = in.nextInt() - 1;
                graph[v1][v2] = 1;
                graph[v2][v1] = 1;
            }
            yesOrNo(graph);

        }

    }

    private static void yesOrNo(int[][] graph) {
        int m = graph.length;
        boolean[] isHandled = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (isHandled[i]) continue;
            isHandled[i] = true;
            for (int j = i + 1; j < m; j++) {

                if (i != j && graph[i][j] == 0) {
                    for (int k = 0; k < m; k ++) {
                        if (graph[i][k] != graph[j][k]) {
                            System.out.println("No");
                            return;
                        }
                    }
                    isHandled[j] = true;
                }
            }
        }
        System.out.println("Yes");
    }
}
