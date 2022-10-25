package br.com.letscode.desafios.bejv002.run;

import br.com.letscode.desafios.bejv002.classes.Exercise;
import br.com.letscode.desafios.bejv002.classes.Exercise7;
import br.com.letscode.desafios.bejv002.classes.ExerciseSolution;
import br.com.letscode.desafios.bejv002.classes.ExerciseSolution7;
import br.com.letscode.desafios.bejv002.enums.ExerciseStatement;

public class RunExercises {

    public static void main(String[] args) {

        Exercise exercise = new Exercise7();
        ExerciseSolution solution = new ExerciseSolution7();
        try {
            exercise.print(ExerciseStatement.CHALLENGE7);
            exercise.print(ExerciseStatement.CHALLENGE7_1);
            solution.solution();

        } catch (Exception exception){
            System.out.println(exception.getMessage() + " - " + exception.getCause());
        }
    }
}