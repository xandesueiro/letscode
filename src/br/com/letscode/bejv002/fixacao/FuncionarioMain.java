package br.com.letscode.bejv002.fixacao;

import java.math.BigDecimal;

public class FuncionarioMain {

    public static void main(String[] args) {
        String nome;
        String cpf;
        BigDecimal salario;
        int diasReaisTrabalhados;

        try {
            nome = "joao da silva";
            cpf = "22233344455";
            salario = new BigDecimal("8500.87");
            diasReaisTrabalhados = 22;
            Funcionario joao = new Funcionario(nome, cpf, salario, diasReaisTrabalhados);
            System.out.println(joao);
            joao.imprimirHollerite(Funcionario.DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA);

            nome = "Maria de Souza Rodrigues";
            cpf = "66677788899";
            salario = new BigDecimal("18500.18");
            diasReaisTrabalhados = 18;
            Funcionario maria = new Funcionario(nome, cpf, salario, diasReaisTrabalhados);
            System.out.println(maria);
            maria.imprimirHollerite(Funcionario.DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA);

            nome = "Maria de Souza Rodrigues";
            cpf = "66677788899";
            salario = new BigDecimal("18500.18");
            diasReaisTrabalhados = 25;
            Funcionario mariaSouza = new Funcionario(nome, cpf, salario, diasReaisTrabalhados);
            System.out.println(mariaSouza);
            mariaSouza.imprimirHollerite(Funcionario.DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA);

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
