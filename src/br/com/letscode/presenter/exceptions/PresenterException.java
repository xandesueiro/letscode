package br.com.letscode.presenter.exceptions;

public class PresenterException extends Exception{
    private String error;

    public PresenterException(String errorMessage){
        super();
        StringBuffer sb = new StringBuffer();
        sb.append("ERROR... WATCH OUT!\n");
        sb.append("Error message: " + errorMessage + " \n");
        sb.append("Excpetion message: " + super.getMessage() + " \n");
        this.error = sb.toString();
    }

    public String getError() {
        return error;
    }
}
