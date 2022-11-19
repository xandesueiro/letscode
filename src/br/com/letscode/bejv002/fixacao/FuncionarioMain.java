package br.com.letscode.bejv002.fixacao;

import br.com.letscode.estudo.Funcionario;
import br.com.letscode.estudo.Pessoa;
import br.com.letscode.estudo.services.PessoaService;

import java.math.BigDecimal;

public class FuncionarioMain {

    public static void main(String[] args) {
        String nome;
        String cpf;
        BigDecimal salario;
        int diasReaisTrabalhados;
        PessoaService pessoaService = new PessoaService();

        try {
            nome = "joao da silva";
            cpf = "22233344455";
            salario = new BigDecimal("8500.87");
            diasReaisTrabalhados = 22;

            Pessoa joao = pessoaService.carregarPessoa(PessoaService.TIPO_PESSOA_FUNCIONARIO,
                    nome,
                    cpf,
                    salario,
                    diasReaisTrabalhados,
                    null);

            System.out.println(joao);
            pessoaService.imprimirHollerite((Funcionario) joao);

            nome = "Maria de Souza Rodrigues";
            cpf = "66677788899";
            salario = new BigDecimal("18500.18");
            diasReaisTrabalhados = 18;
            Pessoa maria = pessoaService.carregarPessoa(PessoaService.TIPO_PESSOA_FUNCIONARIO,
                    nome,
                    cpf,
                    salario,
                    diasReaisTrabalhados,
                    null);

            System.out.println(maria);
            pessoaService.imprimirHollerite((Funcionario) maria);

            nome = "Maria de Souza Rodrigues";
            cpf = "66677788899";
            salario = new BigDecimal("18500.18");
            diasReaisTrabalhados = 25;
            Pessoa mariaSouza = pessoaService.carregarPessoa(PessoaService.TIPO_PESSOA_FUNCIONARIO,
                    nome,
                    cpf,
                    salario,
                    diasReaisTrabalhados,
                    null);
            System.out.println(mariaSouza);
            pessoaService.imprimirHollerite((Funcionario)mariaSouza);

            System.out.println("\n");
            System.out.println("Testes gerais: ");
            System.out.println("--> Objeto joao equals Objeto maria: " + joao.equals(maria));
            System.out.println("--> Objeto maria equals ao Objeto mariaSouza: " + maria.equals(mariaSouza));
            if (maria == mariaSouza) {
                System.out.println("--> Objeto maria == ao Objeto mariaSouza: true");
            }else{
                System.out.println("--> Objeto maria == ao Objeto mariaSouza: false");
            }
            if (maria instanceof Funcionario) {
                System.out.println("maria é uma instância de objeto da classe Funcionario");
            }
            if (maria instanceof Object) {
                System.out.println("maria é uma instância de objeto da classe Object");
            }

        }catch (Exception e){
            System.out.println("Erro --> " + e.getMessage());
            System.out.println(e);
        }
    }
}
