package br.com.letscode.desafios.bejv002.classes;

import br.com.letscode.desafios.bejv002.enums.ExerciseStatement;

public abstract class Exercise {
    protected String mainStatement;
    protected String[] subStatements;

    protected abstract void createMainStatement();
    protected abstract void createSubStatements();
    public abstract void print(ExerciseStatement stmt) throws Exception;

    public String getMainStatement(){
        return this.mainStatement;
    }

    public String[] getSubStatements(){
        return this.subStatements;
    }

}
