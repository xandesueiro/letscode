package br.com.letscode.estudo.services;

import br.com.letscode.estudo.Funcionario;
import br.com.letscode.estudo.Pessoa;
import br.com.letscode.estudo.Terceiro;
import br.com.letscode.estudo.validacao.ValidacaoFuncionario;
import br.com.letscode.estudo.validacao.ValidacaoPessoa;
import br.com.letscode.estudo.validacao.ValidacaoTerceiro;
import br.com.letscode.presenter.exceptions.ValidacaoException;
import br.com.letscode.utilitarios.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Objects;

public class PessoaService {
    public static String TIPO_PESSOA_FUNCIONARIO = "F";
    public static String TIPO_PESSOA_TERCEIRO = "T";

    public Pessoa carregarPessoa(String tipoPessoa,
                                 String strNome,
                                 String strCPF,
                                 BigDecimal salarioFuncionario,
                                 int quantidadeDiasReaisTrabalhadosPeloFuncionario,
                                 String cpnjEmpresaTerceiro) throws  ValidacaoException{
        Pessoa pessoa = null;
        if (tipoPessoa.equalsIgnoreCase(TIPO_PESSOA_FUNCIONARIO)) {
            Funcionario funcionario = new Funcionario(strNome, strCPF);
            funcionario.setSalario(salarioFuncionario);
            funcionario.setQuantidadeDiasTrabalhado(quantidadeDiasReaisTrabalhadosPeloFuncionario);

            calculaSalarioProporcionalDiasTrabalhados(funcionario);

            pessoa = funcionario;

        }else if (tipoPessoa.equalsIgnoreCase(TIPO_PESSOA_TERCEIRO)) {
            Terceiro terceiro = new Terceiro(strNome, strCPF, cpnjEmpresaTerceiro);

            pessoa = terceiro;
        }else {
            throw new ValidacaoException("Tipo informado de pessoa não reconhecido");
        }

        validarDocumento(pessoa);

        return pessoa;
    }

    public void validarDocumento(Pessoa pessoa) throws ValidacaoException{
        ValidacaoPessoa validacaoPessoa = (pessoa instanceof Funcionario) ? new ValidacaoFuncionario()
                                                                            :
                                                                            new ValidacaoTerceiro();
        validacaoPessoa.validarDocumento(pessoa);

    }

    public String formatarDocumentoCPF(Pessoa pessoa) throws ValidacaoException{
        ValidacaoPessoa validacaoPessoa = (pessoa instanceof Funcionario) ? new ValidacaoFuncionario()
                                                                            :
                                                                            new ValidacaoTerceiro();
        return validacaoPessoa.formatarDocumentoCPF(pessoa);

    }

    public String formatarDocumentoCNPJ(Pessoa pessoa) throws ValidacaoException{
        String cnpj = "";
        if (pessoa instanceof Terceiro) {
            cnpj = new ValidacaoTerceiro().formatarDocumentoCNPJ((Terceiro) pessoa);
        }

        return cnpj;

    }

    public void imprimirHollerite(Funcionario funcionario) throws ValidacaoException {

        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------------").append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Dia e Horario da Impressão: ").append(Utils.pegarDataAtual(Utils.DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA)).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Nome do Funcionário: ").append(funcionario.getNome().toUpperCase()).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- CPF do Funcionário: ").append( formatarDocumentoCPF(funcionario) ).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Dias Úteis: " + funcionario.DIAS_UTEIS_MES_DE_TRABALHO + " dias").append("\n");
        sb.append("- Salario do Funcionário: ").append(formatarSalarioEmMoedaLocal(funcionario.getSalario())).append("\n");
        sb.append("- Dias Reais Trabalhados pelo Funcionário: ").append(funcionario.getQuantidadeDiasTrabalhado()).append(" dias").append("\n");
        sb.append("- Salario Proporcional de Funcionário: R$").append(formatarSalarioEmMoedaLocal(funcionario.getSalarioProporcional())).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Informações de controle").append("\n");
        sb.append("- --> HasCode: @").append(hashCode()).append("\n");
        sb.append("- --> this = ").append(this).append("\n");
        sb.append("- --> super = ").append(super.toString()).append("\n");
        sb.append("- --> hash this = ").append(this.hashCode()).append("\n");
        sb.append("- --> hash super = ").append(super.hashCode()).append("\n");
        sb.append("--------------------------------------------------------").append("\n");

        System.out.println(sb);
    }
    private String criaLinhaSeparacaoHollertite(){
        return "-                                                      -";
    }

    public String formatarSalarioEmMoedaLocal( BigDecimal salario ) {
        String valorFormatado;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        valorFormatado = nf.format(Objects.requireNonNullElseGet(salario, () -> new BigDecimal(0.00)));

        return valorFormatado;
    }

    public void calculaSalarioProporcionalDiasTrabalhados(Funcionario funcionario){
        double qtdeDiasTrabalhado = funcionario.getQuantidadeDiasTrabalhado();
        double qtdeDiasUteisParaTrabalho = Funcionario.DIAS_UTEIS_MES_DE_TRABALHO;
        BigDecimal diasProporcionaisDeTrabalho  = new BigDecimal(qtdeDiasTrabalhado / qtdeDiasUteisParaTrabalho);
        BigDecimal bdSalarioProporcional = diasProporcionaisDeTrabalho.multiply(funcionario.getSalario());

        funcionario.setSalarioProporcional(BigDecimal.valueOf(bdSalarioProporcional
                .setScale(2,
                        RoundingMode.UP)
                .doubleValue())
        );
    }

}
