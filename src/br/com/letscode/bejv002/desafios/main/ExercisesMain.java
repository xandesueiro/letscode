package br.com.letscode.bejv002.desafios.main;

import br.com.letscode.bejv002.desafios.classes.Exercise7;
import br.com.letscode.bejv002.desafios.classes.ExerciseSolution;
import br.com.letscode.bejv002.desafios.classes.ExerciseSolution7;
import br.com.letscode.bejv002.desafios.classes.Exercise;
import br.com.letscode.bejv002.desafios.enums.ExerciseStatement;

public class ExercisesMain {

    public static void main(String[] args) {

        Exercise exercise = new Exercise7();
        ExerciseSolution solution = new ExerciseSolution7();
        try {
            exercise.print(ExerciseStatement.CHALLENGE7);
            exercise.print(ExerciseStatement.CHALLENGE7_1);
            solution.solution(ExerciseStatement.CHALLENGE7_1);

            System.out.println("-------------------------------NEXT------------------------------------\n");

            exercise.print(ExerciseStatement.CHALLENGE7_2);
            solution.solution(ExerciseStatement.CHALLENGE7_2);

            System.out.println("-------------------------------NEXT------------------------------------\n");

            exercise.print(ExerciseStatement.CHALLENGE7_3);
            solution.solution(ExerciseStatement.CHALLENGE7_3);

        } catch (Exception exception){
            System.out.println(exception.getMessage() + " - " + exception.getCause());
        }
    }
}
