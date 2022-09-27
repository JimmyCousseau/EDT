
public class Tab_matrices {
    public static void main(String[] args) {
        int col = 2;
        int row = 2;
        int[][] matrixv = new int[2][2];
        matrixv[0][0] = 3;
        matrixv[0][1] = 3;
        matrixv[1][0] = 3;
        matrixv[1][1] = 3;
        int[][] matrix = getMatrix(row, col);
        AffichageMatrix(matrix);
        System.out.println(ValMin(matrix));
        System.out.println(PosValMin(matrix));
        System.out.println(CarreMagique(matrixv));
    }

    public static int[][] getMatrix(int row, int col) {
        if (row == 0 && col == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[row][col];
        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                matrix[r][c] = (int) (Math.random() * 20) + 10;
            }
        }

        return matrix;
    }
    
    public static void AffichageMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static int ValMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] < min) {
                    min = matrix[j][i];
                }
            }
        }
        return min;
    }
    
    public static String PosValMin(int[][] matrix) {
        int min = matrix[0][0];
        String pos = "[0, 0]";
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] < min) {
                    min = matrix[j][i];
                    pos = "[" + j + ", " + i + "]";
                }
            }
        }
        return pos;
    }

    public static String CarreMagique(int[][] matrix) {
        String reponse = "";
        int somme = matrix[0][0] + matrix[0][1];
        if (matrix[0].length < 2 || matrix.length < 2) {
            reponse = "C'est un carré magique";
        }
        else {
            if (matrix[0].length != matrix.length) {
                reponse = "Ce n'est pas un carré magique";
            }
            else {
                for (int i = 1; i < matrix.length; i++) {
                    if (somme != matrix[i][0] + matrix[i][1]) {
                        reponse = "Ce n'est pas un carré magique";
                        break;
                    }
                }
                if (reponse == "") {
                    for (int i = 0; i < matrix[0].length; i++) {
                        if (somme != matrix[0][i] + matrix[1][i]) {
                            reponse = "Ce n'est pas un carré magique";
                            break;
                        }
                    }
                }
                else {
                    if (reponse == "") {
                        for (int i = 0; i < matrix[0].length; i++) {
                            if (somme != matrix[i][i] + matrix[i][i]) {
                                reponse = "Ce n'est pas un carré magique";
                                break;
                            }
                        }
                    }
                    else {
                        if (reponse == "") {
                            for (int i = 0; i < matrix[0].length; i++) {
                                if (somme != matrix[matrix[0].length - i][i] + matrix[matrix[0].length - i][i]) {
                                    reponse = "Ce n'est pas un carré magique";
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (reponse == "") {
            reponse = "C'est un carré magique";
        }
        return reponse;
    }
}
