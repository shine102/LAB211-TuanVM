
public class Display {
    static void displayMatrix(int [][] matrix){
        // go from first element of row to last element of row of matrix
        for (int i = 0; i < matrix.length; i++) {
            //go from first element of column to last element of column of matrix
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }
    static void displayAddition(int [][] matrix1, int[][] matrix2, int[][] result){
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    } 
    static void displaySubstraction(int[][] matrix1, int[][] matrix2, int[][] result){
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
    
    static void displayMultiplication(int[][] matrix1, int[][] matrix2, int[][] result){
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
    
    static void displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }
}
