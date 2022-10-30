package br.com.letscode.bejv002.desafios.classes;

import br.com.letscode.bejv002.desafios.enums.ExerciseStatement;

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
