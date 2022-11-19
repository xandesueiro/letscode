package br.com.letscode.presenter.interfaces;

import br.com.letscode.estudo.Banco;
import br.com.letscode.presenter.exceptions.PresenterException;

import java.util.Scanner;

public interface PresenterQuiz <T extends Scanner, U extends Banco> extends Presenter {

    String interagirPerguntas(T scanner, String pergunta) throws PresenterException ;

}
