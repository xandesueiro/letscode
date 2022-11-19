package br.com.letscode.presenter.implementation;

import br.com.letscode.estudo.Banco;
import br.com.letscode.estudo.Funcionario;
import br.com.letscode.estudo.Terceiro;
import br.com.letscode.estudo.services.PessoaService;
import br.com.letscode.estudo.validacao.ValidacaoFuncionario;
import br.com.letscode.estudo.validacao.ValidacaoPessoa;
import br.com.letscode.estudo.validacao.ValidacaoTerceiro;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.exceptions.ValidacaoException;
import br.com.letscode.presenter.interfaces.Presenter;
import br.com.letscode.presenter.interfaces.PresenterQuiz;

import java.util.Map;
import java.util.Scanner;

public class ConsoleImp implements PresenterQuiz<Scanner, Banco> {

    @Override
    public void print(Banco banco) throws PresenterException {
        PessoaService pessoaService = new PessoaService();

        StringBuffer sb = new StringBuffer();
        try {
            if (banco instanceof Funcionario) {
                sb.append("Nome                : ").append(((Funcionario) banco).getNome()).append("\n");
                sb.append("Documento           : ").append(pessoaService.formatarDocumentoCPF((Funcionario) banco)).append("\n");
                sb.append("Salário             : ").append(pessoaService.formatarSalarioEmMoedaLocal(((Funcionario) banco).getSalario())).append("\n");
                sb.append("Salário Proporcional: ").append(pessoaService.formatarSalarioEmMoedaLocal(((Funcionario) banco).getSalarioProporcional())).append("\n");
                System.out.println(sb);
            } else if (banco instanceof Terceiro) {
                sb.append("Nome                : ").append(((Terceiro) banco).getNome()).append("\n");
                sb.append("Documento           : ").append(pessoaService.formatarDocumentoCPF((Terceiro) banco)).append("\n");
                sb.append("Documento Empresa   : ").append(pessoaService.formatarDocumentoCNPJ((Terceiro) banco)).append("\n");
                System.out.println(sb);
            } else {
                System.out.println(banco.toString());
            }
        }catch (ValidacaoException validacaoException){
            throw new PresenterException(validacaoException.getMessage());
        }

    }

    @Override
    public String interagirPerguntas(Scanner scanner, String pergunta) throws PresenterException  {
        String resposta = "";
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        System.out.printf(pergunta);
        resposta = scanner.nextLine();

        return resposta;
    }

}
