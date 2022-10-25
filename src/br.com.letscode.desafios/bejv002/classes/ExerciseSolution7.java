package br.com.letscode.desafios.bejv002.classes;

import br.com.letscode.desafios.bejv002.enums.ExerciseStatement;
import br.com.letscode.desafios.bejv002.utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ExerciseSolution7 extends  ExerciseSolution{

    private final static int ROWS = 6;
    private final static int COLUMNS = 5;
    private final static double FIRST_COLUMN = 100.00;
    private final static double LAST_COLUMN = -3.00;
    private final static double FIRST_ROW = 20.00;
    private final static double LAST_ROW = 20.00;
    private final static double ZERO = 0.00;

    private final static int IGNORE_FIRST_ROW = 0;
    private final static int IGNORE_LAST_ROW = ROWS - 1;
    private final static int IGNORE_FIRST_COLUMN = 0;
    private final static int IGNORE_LAST_COLUMN = COLUMNS - 1;

    private double[][] initialMatrix;

    public void solution(){
        System.out.println("SOLUTION EXERCISE " + ExerciseStatement.CHALLENGE7);
        loadMatrix();
        print(this.initialMatrix);

        int cont = 0;
        boolean isEqual = false;
        double sumMatrix1;
        double sumMatrix2;
        double[][] matrix1 = this.initialMatrix;

        System.out.println("\nITERATE MATRIX");
        while (!isEqual){
            System.out.println("\n==> iterate: " + ++cont );
            sumMatrix1 = Utils.sumMatrix(matrix1, ROWS, COLUMNS);
            System.out.println("Total = " + sumMatrix1);
            double[][] matrix2 = iterateMatrix(matrix1);
            print(matrix2);
            sumMatrix2 = Utils.sumMatrix(matrix2, ROWS, COLUMNS);
            System.out.println("Total = " + sumMatrix2);
            isEqual = Utils.isSumEqual(sumMatrix1, sumMatrix2);
            matrix1 = matrix2;
        }

        System.out.println("The answer for the exercise 1 is equal " + cont + " interactions.");
    }

    private void loadMatrix(){
        this.initialMatrix = new double[ROWS][];

        //int j =0;
        for (int i = 0; i < ROWS; i++) { //row index
            this.initialMatrix[i] = new double[COLUMNS]; //cria as colunas dentro da linha

            for (int j = 0; j < COLUMNS; j++) { //column index
                defineColumnValue(i, j);
            }
            defineRowValue(i);
        }
    }

    @Override
    public void print(double[][] paramMatrix) {
        for (double[] matrix : paramMatrix) {
            //System.out.printf("[%s][%s] = %3s\n",  i, j, this.initialMatrix[i][j]);
            System.out.println(Arrays.toString(matrix));
        }
    }

    private void defineColumnValue(int _i, int _j){
        if (_j == 0) {
            this.initialMatrix[_i][_j] = FIRST_COLUMN;
        } else if (_j == (COLUMNS-1)) {
            this.initialMatrix[_i][_j] = LAST_COLUMN;
        } else {
            this.initialMatrix[_i][_j] = ZERO;
        }
    }

    private void defineRowValue(int _i){
        if (_i == 0){
            for (int j = 0; j < COLUMNS; j++) {
                this.initialMatrix[_i][j] = FIRST_ROW;
            }
        } else if (_i == (ROWS - 1)) {
            for (int j = 0; j < COLUMNS; j++) {
                this.initialMatrix[_i][j] = LAST_ROW;
            }
        }
    }

    private double[][] iterateMatrix(double[][] matrix){
        double right_value;
        double left_value;
        double top_value;
        double bottom_value;
        double average;
        double[][] iterateMatrix = matrix;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ( i != IGNORE_FIRST_ROW
                  && i != IGNORE_LAST_ROW
                  && j != IGNORE_FIRST_COLUMN
                  && j != IGNORE_LAST_COLUMN
                ){
                    right_value = iterateMatrix[i][j+1];
                    left_value = iterateMatrix[i][j-1];
                    top_value = iterateMatrix[i-1][j];
                    bottom_value = iterateMatrix[i-1][j];

                    average = (right_value + left_value + top_value + bottom_value) / 4;

                    iterateMatrix[i][j] = new BigDecimal(average).setScale(2, RoundingMode.UP).doubleValue();
                }

            }

        }
        return iterateMatrix;
    }

}
