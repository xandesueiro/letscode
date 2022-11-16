package br.com.letscode.app;

import br.com.letscode.bejv002.fixacao.Funcionario;
import br.com.letscode.estudo.Banco;
import br.com.letscode.estudo.Terceiro;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.exceptions.QuizException;
import br.com.letscode.presenter.implementation.ConsoleImp;
import br.com.letscode.presenter.implementation.KeyValueImp;
import br.com.letscode.presenter.interfaces.Presenter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class FolhaPagamentoApp{

    public static final int TYPE_PRESENTER_CONSOLE = 0;
    public static final int TYPE_PRESENTER_KEY_VALUE = 1;

    private ArrayList<String> scriptPerguntas;
    private FolhaPagamentoApp folhaPagamentoApp;

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

    public void apresentar(int typePresenter) throws Exception {
        String strTipo;
        String strNome;
        String strNumeroDocumento;
        String strSalario;
        String strDiasTrabalhados;
        String strDocumentoEmpresa;

        Presenter console = new ConsoleImp();

        switch (typePresenter){
            case TYPE_PRESENTER_CONSOLE -> {
                 strTipo = quiz(console, this.scriptPerguntas.get(0));
                 strNome = quiz(console, this.scriptPerguntas.get(1));
                 strNumeroDocumento = quiz(console, this.scriptPerguntas.get(2));

                 if (strTipo.equals("F")) {
                     strSalario = quiz(console, this.scriptPerguntas.get(4));
                     strDiasTrabalhados = quiz(console, this.scriptPerguntas.get(5));
                     Funcionario funcionario = new Funcionario(strNome, strNumeroDocumento, new BigDecimal(strSalario), Integer.parseInt(strDiasTrabalhados));
                     console.print(funcionario);

                     funcionario.imprimirHollerite(Funcionario.DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA);

                 }else{
                     strDocumentoEmpresa = quiz(console, this.scriptPerguntas.get(3));
                     Terceiro terceiro = new Terceiro(strNome, strNumeroDocumento, strDocumentoEmpresa);
                     console.print(terceiro);
                 }
            }

            case TYPE_PRESENTER_KEY_VALUE -> {
                Presenter keyValue = new KeyValueImp();

                String nome = "joao da silva";
                String cpf = "22233344455";
                BigDecimal salario = new BigDecimal("8500.87");
                int  diasReaisTrabalhados = 22;
                try {
                    Funcionario funcionario = new Funcionario(nome, cpf, salario, diasReaisTrabalhados);

                    String keyValueAnswer = keyValue.prepare(funcionario);
                    System.out.println(keyValueAnswer);
                }catch (Exception ex){
                    throw new PresenterException("");
                }
            }
            default -> System.out.println();
        }
    }

    private String quiz(Presenter console, String pergunta) throws PresenterException{
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
