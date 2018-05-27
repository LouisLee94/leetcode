import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = 0;
        if (m != 0) n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m*n);
      //  if (m*n == 0) return list;

        int min = Math.min(m, n);
        for (int i = 0; i < (min + 1)/2; i++) {
            for (int j = i; j < n - i; j++)
                list.add(matrix[i][j]);
            for (int j = i + 1; j < m - i; j++)
                list.add(matrix[j][n-1-i]);
            if (i == (min+1)/2-1 && min%2 == 1) break;
            for (int j = n-1-i-1; j >= i; j--)
                list.add(matrix[m-1-i][j]);
            for (int j = m-1-i-1; j > i; j--)
                list.add(matrix[j][i]);
        }
        return list;

    }

//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.size();
//        Integer[] n = (Integer[]) list.toArray();
//        int a = objects.length;
//    }
}

