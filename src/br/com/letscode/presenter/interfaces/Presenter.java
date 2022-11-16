package br.com.letscode.presenter.interfaces;

import br.com.letscode.estudo.Banco;
import br.com.letscode.estudo.Pessoa;
import br.com.letscode.presenter.exceptions.PresenterException;

import java.util.Scanner;

public interface Presenter <T extends Scanner, U extends Banco>{

    public void print(U banco) throws PresenterException;

    public String interagirPerguntas(T scanner, String pergunta) throws PresenterException ;

    public String prepare(U banco) throws PresenterException;


}
