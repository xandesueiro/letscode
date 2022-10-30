package br.com.letscode.bejv002.desafios.classes;

import java.util.Scanner;

public class ExerciseForm {

    public static String simpleAnswer(String question){
        Scanner sc = new Scanner(System.in);
        System.out.printf(question);
        return sc.next();
    }

    public static double[] batchResponseDouble(String question, int dimensions){
        double[] answers = new double[dimensions];

        for(int i=0;i<dimensions;i++){
            Scanner sc = new Scanner(System.in);
            System.out.printf(question + i +": ");
            answers[i] = sc.nextDouble();
        }

        return  answers;
    }

}
