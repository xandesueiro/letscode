package br.com.letscode.desafios.bejv002.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static double sumMatrix(double[][] matrix, int totalRows, int totalColumns){
        double sum = 0.00;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                sum += matrix[i][j];
            }
        }

        return new BigDecimal(sum).setScale(2, RoundingMode.UP).doubleValue();
    }

    public static boolean isSumEqual(double sumMatrix1, double sumMatrix2){
        boolean isEqual = false;

        isEqual = sumMatrix1 == sumMatrix2;

        return isEqual;
    }
}
