package br.com.letscode.app;

import br.com.letscode.estudo.Banco;
import br.com.letscode.estudo.Funcionario;
import br.com.letscode.estudo.Pessoa;
import br.com.letscode.estudo.services.PessoaService;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.exceptions.QuizException;
import br.com.letscode.presenter.exceptions.ValidacaoException;
import br.com.letscode.presenter.implementation.ConsoleImp;
import br.com.letscode.presenter.implementation.KeyValueImp;
import br.com.letscode.presenter.interfaces.PresenterKeyValue;
import br.com.letscode.presenter.interfaces.PresenterQuiz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FolhaPagamentoApp{

    public static final int TYPE_PRESENTER_CONSOLE = 0;
    public static final int TYPE_PRESENTER_KEY_VALUE = 1;

    private ArrayList<String> scriptPerguntas;

    public FolhaPagamentoApp(){
        if (this.scriptPerguntas == null){
            this.scriptPerguntas = new ArrayList<>();
            this.scriptPerguntas.add(0, "--> Gostaria de cadastrar: (F) Funcionario ou (T) Terceiro: ");
            this.scriptPerguntas.add(1, "--> Informe o nome                                        : ");
            this.scriptPerguntas.add(2, "--> Informe o numero do documento                         : ");
            this.scriptPerguntas.add(3, "--> Informe o numero do documento da empresa              : ");
            this.scriptPerguntas.add(4, "--> Informe o salario                                     : ");
            this.scriptPerguntas.add(5, "--> Informe a quantidade de dias trabalhados              : ");
            this.scriptPerguntas.add(6, "--> Deseja prosseguir? (S) Sim ou (N) Não ");
        }
    }

    public void apresentar(int typePresenter) throws ValidacaoException, PresenterException {
        String strTipo;
        String strNome;
        String strNumeroDocumento;
        String strSalario;
        String strDiasTrabalhados;
        String strDocumentoEmpresa;

        PessoaService pessoaService = new PessoaService();

        switch (typePresenter){
            case TYPE_PRESENTER_CONSOLE -> {
                 PresenterQuiz<Scanner, Banco> console = new ConsoleImp();

                 strTipo = quiz(console, this.scriptPerguntas.get(0));
                 strNome = quiz(console, this.scriptPerguntas.get(1));
                 strNumeroDocumento = quiz(console, this.scriptPerguntas.get(2));

                 if (strTipo.equalsIgnoreCase("F")) {
                     strSalario = quiz(console, this.scriptPerguntas.get(4));
                     strDiasTrabalhados = quiz(console, this.scriptPerguntas.get(5));

                     Pessoa funcionario = pessoaService.carregarPessoa(PessoaService.TIPO_PESSOA_FUNCIONARIO,
                                                                            strNome,
                                                                            strNumeroDocumento,
                                                                            new BigDecimal(strSalario),
                                                                            Integer.parseInt(strDiasTrabalhados),
                                                                            null);

                     console.print(funcionario);

                     pessoaService.imprimirHollerite((Funcionario)funcionario);

                 }else if (strTipo.equalsIgnoreCase("T")){
                     strDocumentoEmpresa = quiz(console, this.scriptPerguntas.get(3));

                     Pessoa terceiro = pessoaService.carregarPessoa(PessoaService.TIPO_PESSOA_TERCEIRO,
                             strNome,
                             strNumeroDocumento,
                             null,
                             0,
                             strDocumentoEmpresa);

                     console.print(terceiro);

                 } else{
                     throw new PresenterException("Falha geral na opção selecionada");
                 }
            }

            case TYPE_PRESENTER_KEY_VALUE -> {
                PresenterKeyValue<Map, Banco> keyValue = new KeyValueImp();

                String nome = "joao da silva";
                String cpf = "22233344455";
                BigDecimal salario = new BigDecimal("8500.87");
                int  diasReaisTrabalhados = 25;

                Pessoa funcionario = pessoaService.carregarPessoa(PessoaService.TIPO_PESSOA_FUNCIONARIO,
                        nome,
                        cpf,
                        salario,
                        diasReaisTrabalhados,
                        null);

                String keyValueAnswer = keyValue.execute(funcionario);
                System.out.println(keyValueAnswer);
            }
            default -> System.out.println();
        }
    }

    private String quiz(PresenterQuiz<Scanner, Banco> console, String pergunta) throws PresenterException{
        Scanner scanner = new Scanner(System.in);
        String resposta = "";

        boolean processarLoop = true;
        boolean manteveErro = false;
        int tentativas = 1;
        int cont = 0;

        while (processarLoop && cont++ <= tentativas) {
            resposta = console.interagirPerguntas(scanner, pergunta);

            if ( null != resposta && !resposta.isEmpty() ){
                processarLoop = false;
                manteveErro = false;
            }else{
                System.out.println("Algo não está correto... favor verificar a informação digitada. Obs: Caso esteja utilizando decimais, utilize \".\"");
                manteveErro = true;
                resposta = console.interagirPerguntas(scanner, this.scriptPerguntas.get(6));

                if (null != resposta && resposta.equals("N")){
                    break;
                }
            }
        }
        if (manteveErro){
            throw new QuizException("Houve um erro no processo de respostas. Favor re-iniciar: " + this.getClass());
        }

        return resposta;
    }
}
