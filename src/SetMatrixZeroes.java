public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstClomun = false, firstRow = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                firstClomun = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstClomun) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }



    public static void main(String[] args) {
        int[][] matrix = {{0,1}};
                //{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        new SetMatrixZeroes().setZeroes(matrix);
    }
}
