package br.com.letscode.presenter.implementation;

import br.com.letscode.estudo.Banco;
import br.com.letscode.estudo.Pessoa;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.interfaces.Presenter;

import java.util.Scanner;

public class ConsoleImp implements Presenter{

    private Scanner scanner;

    public ConsoleImp(){

    }
    @Override
    public void print(Banco banco) throws PresenterException {
        System.out.println(banco.toString());
    }

    @Override
    public String interagirPerguntas(Scanner scanner, String pergunta) throws PresenterException  {
        String resposta = "";
        if (scanner != null) {
            this.scanner = scanner;
        }else{
            this.scanner = new Scanner(System.in);
        }

        System.out.printf(pergunta);
        resposta = this.scanner.nextLine();

        return resposta;
    }

    @Override
    public String prepare(Banco banco) throws PresenterException {
        throw new PresenterException("Esta classe " + this.getClass() + " não implementa este comportamento");
        //return null;
    }
}
