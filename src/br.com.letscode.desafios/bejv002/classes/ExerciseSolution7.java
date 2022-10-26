package br.com.letscode.desafios.bejv002.classes;

import br.com.letscode.desafios.bejv002.enums.ExerciseStatement;
import br.com.letscode.desafios.bejv002.utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ExerciseSolution7 extends  ExerciseSolution{

    private final static int ROWS = 6;
    private final static int COLUMNS = 5;

    private final static int DIMENSION = 4;

    private final static double ZERO = 0.00;

    private static final int TOTAL_INTERACTION = 6;
    private static final double ERROR_ACCEPTABLE = 0.9;

    private final static int IGNORE_FIRST_ROW = 0;
    private final static int IGNORE_LAST_ROW = ROWS - 1;
    private final static int IGNORE_FIRST_COLUMN = 0;
    private final static int IGNORE_LAST_COLUMN = COLUMNS - 1;

    private double[][] initialMatrix;

    public void solution(ExerciseStatement stm){

        switch (stm){
            case CHALLENGE7_1 -> solution7_1();
            case CHALLENGE7_2 -> solution7_2();
            case CHALLENGE7_3 -> solution7_3();
        }
    }

    public void solution7_1(){
        System.out.println("SOLUTION EXERCISE " + ExerciseStatement.CHALLENGE7_1);
        //loadMatrix();
        loadMatrix(ROWS, COLUMNS, null);
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
            System.out.println("Total Before Matrix = " + sumMatrix1);
            double[][] matrix2 = iterateMatrix(matrix1, ROWS, COLUMNS);
            print(matrix2);
            sumMatrix2 = Utils.sumMatrix(matrix2, ROWS, COLUMNS);
            System.out.println("Total Current Matrix = " + sumMatrix2);
            isEqual = Utils.isSumEqual(sumMatrix1, sumMatrix2);
            matrix1 = matrix2;
        }

        System.out.println("======================================================================\n\n");
        System.out.println("The answer for the " + ExerciseStatement.CHALLENGE7_1 + " is equal " + cont + " interactions.");
        System.out.println("\n\n======================================================================\n");
    }

    public void solution7_2(){
        System.out.println("\n");
        System.out.println("SOLUTION EXERCISE " + ExerciseStatement.CHALLENGE7_2);
        System.out.println("MAX TOTAL INTERACTIONS " + TOTAL_INTERACTION);
        System.out.println("ERROR DIFFERENCE ACCEPTABLE " + ERROR_ACCEPTABLE);

        loadMatrix(ROWS, COLUMNS, null);
        //loadMatrix();
        print(this.initialMatrix);

        int cont = 0;
        boolean isEqual = false;
        double sumMatrix1;
        double sumMatrix2;
        double[][] matrix1 = this.initialMatrix;
        double diff = 0.00;

        System.out.println("\nITERATE MATRIX");
        while (!isEqual && cont <= TOTAL_INTERACTION){
            System.out.println("\n==> iterate: " + cont );
            sumMatrix1 = Utils.sumMatrix(matrix1, ROWS, COLUMNS);
            System.out.println("Total Before Matrix = " + sumMatrix1);
            double[][] matrix2 = iterateMatrix(matrix1, ROWS, COLUMNS);
            print(matrix2);
            sumMatrix2 = Utils.sumMatrix(matrix2, ROWS, COLUMNS);
            System.out.println("Total Current Matrix = " + sumMatrix2);
            isEqual = Utils.isSumAcceptableError(sumMatrix1, sumMatrix2, ERROR_ACCEPTABLE);
            matrix1 = matrix2;
            diff = Utils.diffTotalMatrix(sumMatrix1, sumMatrix2, 2);
            cont++;
        }

        System.out.println("======================================================================\n\n");
        System.out.println("The answer for the " + ExerciseStatement.CHALLENGE7_2 + " is equal " + cont + " interactions, with an error of " + diff);
        System.out.println("\n\n======================================================================\n");
    }

    public void solution7_3(){
        System.out.println("SOLUTION EXERCISE " + ExerciseStatement.CHALLENGE7_3);
        System.out.println("\n");

        String question = "Enter the maximum of interactions (int): ";
        String answerInteractions = ExerciseForm.simpleAnswer(question);
        System.out.println("MAX TOTAL INTERACTIONS: " + answerInteractions);
        System.out.println("");

        question = "Enter the acceptable amount of errors (double eg 0.9): ";
        String answerAcceptableErrors = ExerciseForm.simpleAnswer(question);
        System.out.println("ERROR DIFFERENCE ACCEPTABLE: " + answerAcceptableErrors);
        System.out.println("");

        question = "Type the decimals (int): ";
        String answerDecimals = ExerciseForm.simpleAnswer(question);
        System.out.println("TOTAL OF DECIMAL PLACES: " + answerDecimals);
        System.out.println("");

        question = "Enter the maximum rows of the array (int): ";
        String rows = ExerciseForm.simpleAnswer(question);
        System.out.println("MAXIMUM OF ROWS: " + rows);
        System.out.println("");

        question = "Enter the maximum columns of the array (int): ";
        String columns = ExerciseForm.simpleAnswer(question);
        System.out.println("MAXIMUM OF COLUMNS: " + columns);
        System.out.println("");

        System.out.println("Type the dimensions: 1)First Row 2)Last Row 3)First Column and 4)Last Column");
        question = "Type the answer";
        double[] matrixUser = ExerciseForm.batchResponseDouble( question, DIMENSION);
        System.out.println("");

        loadMatrix( Integer.parseInt(rows),
                    Integer.parseInt(columns),
                    matrixUser);
        print(this.initialMatrix);

        int cont = 0;
        boolean isEqual = false;
        double sumMatrix1;
        double sumMatrix2;
        double[][] matrix1 = this.initialMatrix;
        double diff = 0.00;

        System.out.println("\nITERATE MATRIX");
        while (!isEqual && cont <= Integer.parseInt(answerInteractions)){
            System.out.println("\n==> iterate: " + cont );
            sumMatrix1 = Utils.sumMatrix(matrix1, Integer.parseInt(rows), Integer.parseInt(columns));
            System.out.println("Total Before Matrix = " + sumMatrix1);
            double[][] matrix2 = iterateMatrix(matrix1, Integer.parseInt(rows), Integer.parseInt(columns));
            print(matrix2);
            sumMatrix2 = Utils.sumMatrix(matrix2, Integer.parseInt(rows), Integer.parseInt(columns));
            System.out.println("Total Current Matrix = " + sumMatrix2);
            isEqual = Utils.isSumAcceptableError(sumMatrix1, sumMatrix2, Double.parseDouble(answerAcceptableErrors));
            matrix1 = matrix2;
            diff = Utils.diffTotalMatrix(sumMatrix1, sumMatrix2, Integer.parseInt(answerDecimals));
            cont++;
        }

        System.out.println("======================================================================\n\n");
        System.out.println("The answer for the " + ExerciseStatement.CHALLENGE7_3 + " is equal " + cont + " interactions, with an error of " + diff);
        System.out.println("\n\n======================================================================\n");
    }

    private void loadMatrix(int rows, int columns, double[] matrixUser){
        this.initialMatrix = new double[rows][];

        double firstColumnDefaultValue;
        double lastColumnDefaultValue;
        double firstRowDefaultValue;
        double lastRowDefaultValue;

        if (matrixUser != null){
            firstColumnDefaultValue = matrixUser[0];
            lastColumnDefaultValue  = matrixUser[1];
            firstRowDefaultValue = matrixUser[2];
            lastRowDefaultValue = matrixUser[3];
        } else{
            firstColumnDefaultValue = 100.00;
            lastColumnDefaultValue  = -3.00;
            firstRowDefaultValue = 20.00;
            lastRowDefaultValue = 20.00;
        }

        //int j =0;
        for (int i = 0; i < rows; i++) { //row index
            this.initialMatrix[i] = new double[columns]; //cria as colunas dentro da linha

            for (int j = 0; j < columns; j++) { //column index
                defineColumnValue(i, j, firstColumnDefaultValue, lastColumnDefaultValue);
            }
            defineRowValue(i, rows, columns, firstRowDefaultValue, lastRowDefaultValue);
        }
    }

    @Override
    public void print(double[][] paramMatrix) {
        for (double[] matrix : paramMatrix) {
            System.out.println(Arrays.toString(matrix));
        }
    }

    private void defineColumnValue(int _i, int _j, double firstColumnDefaultValue, double lastColumnDefaulValue){

        if (_j == 0) {
            this.initialMatrix[_i][_j] = firstColumnDefaultValue;
        } else if (_j == (COLUMNS-1)) {
            this.initialMatrix[_i][_j] = lastColumnDefaulValue;
        } else {
            this.initialMatrix[_i][_j] = ZERO;
        }
    }

    private void defineRowValue(int _i, int qtRows, int qtColumns, double firstRowDefaultValue, double lastRowDefaultValue){
        if (_i == 0){
            for (int j = 0; j < qtColumns; j++) {
                this.initialMatrix[_i][j] = firstRowDefaultValue;
            }
        } else if (_i == (qtRows - 1)) {
            for (int j = 0; j < qtColumns; j++) {
                this.initialMatrix[_i][j] = lastRowDefaultValue;
            }
        }
    }

    private double[][] iterateMatrix(double[][] matrix, int rows, int columns){
        double right_value;
        double left_value;
        double top_value;
        double bottom_value;
        double average;
        double[][] iterateMatrix = matrix;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
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
