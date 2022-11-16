package br.com.letscode.utilitarios;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilitarioMath {

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

    public static boolean isSumAcceptableError(double sumMatrix1, double sumMatrix2, double acceptableError){
        boolean isEqual = false;

        double diff = sumMatrix2 - sumMatrix1;
        isEqual = diff <= acceptableError;

        return isEqual;
    }

    public static double diffTotalMatrix(double sumMatrix1, double sumMatrix2, int scale){
        double diff = sumMatrix2 - sumMatrix1;
        return new BigDecimal(diff).setScale(scale, RoundingMode.UP).doubleValue();
    }
}
