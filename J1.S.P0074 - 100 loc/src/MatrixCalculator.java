
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author la
 */
public class MatrixCalculator {
    
    int[][] getMatrix(Scanner sc, String type, Validator getInput, int row, int column){
        int [][] matrix = new int[row][column];
        // go from first element of row to last element of row of the matrix
        for (int i = 0; i < row; i++){
            // go from first element of column to last element of column of the matrix
            for (int j = 0; j < column; j++){
                matrix[i][j] = getInput.getValueMatrix(sc, "Enter Matrix" + type + "[" + (i + 1) + "][" + (j + 1) + "]:" );
            }
        }
        return matrix;
    }

    void additionMatrix(Scanner sc, Validator getInput) {
        System.out.println("-------- Addition --------");
        int row1 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Row Matrix 1:");
        int column1 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Column Matrix 1:");
        int [][] matrix1 = getMatrix(sc, "1", getInput, row1, column1);
        
        int row2 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Row Matrix 2:");
        int column2 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Column Matrix 2:");
        // check if 2 matrices is same size or not
        if (row2 != row1 || column1 != column2){
            System.err.println("2 matrices must be in the same size!");
            try{
                Thread.sleep(500);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            return;
        }
        int [][] matrix2 = getMatrix(sc, "2", getInput, row2, column2);
    
        int [][] sum = new int[row1][column1];
        // go from first element of row to last element of row of 2 matrix
        for (int i = 0; i < row1; i++){
            // go from first element of column to last element of column of 2 matrix
            for (int j = 0; j < column1; j++){
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        // print result
        Display.displayAddition(matrix1, matrix2, sum);
    }

    void subtractionMatrix(Scanner sc, Validator getInput) {
        System.out.println("-------- Substraction --------");
        int row1 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Row Matrix 1:");
        int column1 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Column Matrix 1:");
        int[][] matrix1 = getMatrix(sc, "1", getInput, row1, column1);
        
        int row2 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Row Matrix 2:");
        int column2 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Column Matrix 2:");
        // check if 2 matrices is same size or not
        if (row2 != row1 || column1 != column2) {
            System.err.println("2 matrices must be in the same size!");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        int[][] matrix2 = getMatrix(sc, "2", getInput, row2, column2);

        int[][] result = new int[row1][column1];
        // go from first element of row to last element of row of 2 matrix
        for (int i = 0; i < row1; i++) {
            // go from first element of column to last element of column of 2 matrix
            for (int j = 0; j < column1; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        // print result
        Display.displaySubstraction(matrix1, matrix2, result);
    }

    void multiplicationMatrix(Scanner sc, Validator getInput) {
        System.out.println("-------- Multiplication --------");
        int row1 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Row Matrix 1:");
        int column1 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Column Matrix 1:");
        int[][] matrix1 = getMatrix(sc, "1", getInput, row1, column1);
        
        int row2 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Row Matrix 2:");
        int column2 = getInput.validateInt(sc, 1, Integer.MAX_VALUE, "Enter Column Matrix 2:");
        // check if the number of column of matrix 1 is same as number of row of matrix 2 or not
        if (column1 != row2) {
            System.err.println("The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix!");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        int[][] matrix2 = getMatrix(sc, "2", getInput, row2, column2);
        
        int[][] result = new int [row1][column2];
        
        // go from first element of row to last element of row of matrix 1
        for (int i = 0; i < row1; i++){
            // go from first element of row to last element of row of matrix 2
            for (int j = 0; j < row2; j++){
                // go from first element of column to last element of column of matrix 2
                for (int k = 0; k < column2; k++){
                    result[i][k] += matrix1[i][j] * matrix2[j][k];
                }
            }
        }
        
        Display.displayMultiplication(matrix1, matrix2, result);
    }
    
}
