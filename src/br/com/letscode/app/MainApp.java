package br.com.letscode.app;

import br.com.letscode.estudo.Banco;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.implementation.ConsoleImp;
import br.com.letscode.presenter.interfaces.Presenter;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        FolhaPagamentoApp folhaPagamentoApp = new FolhaPagamentoApp();
        Presenter<Scanner, Banco> console = new ConsoleImp();

        try {
            System.out.println("\n==============================================================\n");
            System.out.println("Escolha a opção do menu: \n");
            String resposta = console.interagirPerguntas(null, "0- Visualizador Console ou 1- Visualizador Chave-Valor: ");

            folhaPagamentoApp.apresentar(Integer.parseInt(resposta));

            System.out.println("\n==============================================================\n");


        } catch (PresenterException presenterException) {
            System.out.println(presenterException.getError());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
