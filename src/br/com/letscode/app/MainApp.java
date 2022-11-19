package br.com.letscode.app;

import br.com.letscode.estudo.Banco;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.exceptions.ValidacaoException;
import br.com.letscode.presenter.implementation.ConsoleImp;
import br.com.letscode.presenter.interfaces.Presenter;
import br.com.letscode.presenter.interfaces.PresenterQuiz;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        FolhaPagamentoApp folhaPagamentoApp = new FolhaPagamentoApp();
        PresenterQuiz<Scanner, Banco> console = new ConsoleImp();

        try {
            interagirUsuario();
        } catch (PresenterException presenterException) {
            System.out.println(presenterException.getError());
        } catch (ValidacaoException validacaoException) {
            System.out.println(validacaoException.getMessage());
        }
    }

    private static void interagirUsuario() throws PresenterException, ValidacaoException {
        FolhaPagamentoApp folhaPagamentoApp = new FolhaPagamentoApp();
        PresenterQuiz<Scanner, Banco> console = new ConsoleImp();

        System.out.println("\n==============================================================\n");
        System.out.println("Escolha a opção do menu: \n");
        String resposta = console.interagirPerguntas(null,"0- Visualizador Console \n"
                + "1- Visualizador Chave-Valor \n"
                + "X- para sair: \n"
                + "-->  ");

        if (!resposta.equalsIgnoreCase("X")) {
            folhaPagamentoApp.apresentar(Integer.parseInt(resposta));

            System.out.println("\n==============================================================\n");

            interagirUsuario();
        }else {
            System.out.println("\n Até + ;-)");
            System.exit(0);
        }
    }
}
