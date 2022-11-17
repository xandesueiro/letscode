package br.com.letscode.bejv002.fixacao;

import br.com.letscode.estudo.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private BigDecimal salarioProporcional;
    private int quantidadeDiasTrabalhado;

    private static final int DIAS_UTEIS_MES_DE_TRABALHO = 22;
    public static final String DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA = "dd/MM/yyyy HH:mm:ss";

    public Funcionario( String strNome,
                        String strCPF,
                        BigDecimal dblSalario,
                        int quantidadeDiasReaisTrabalhadosPeloFuncionario) throws Exception {
        super(strNome, strCPF);

        if (strCPF.length() != 11){
            throw new Exception("CPF inválido... precisa conter 11 numeros - sem separadores");
        }

        this.setSalario(dblSalario);
        this.setQuantidadeDiasTrabalhado(quantidadeDiasReaisTrabalhadosPeloFuncionario);
        calculaSalarioProporcionalDiasTrabalhados();
    }

    public void calculaSalarioProporcionalDiasTrabalhados(){
        double qtdeDiasTrabalhado = getQuantidadeDiasTrabalhado();
        double qtdeDiasUteisParaTrabalho = DIAS_UTEIS_MES_DE_TRABALHO;
        BigDecimal diasProporcionaisDeTrabalho  = new BigDecimal(qtdeDiasTrabalhado / qtdeDiasUteisParaTrabalho);
        BigDecimal bdSalarioProporcional = diasProporcionaisDeTrabalho.multiply(this.getSalario());

        this.setSalarioProporcional(BigDecimal.valueOf(bdSalarioProporcional
                                    .setScale(2,
                                    RoundingMode.UP)
                                    .doubleValue())
                                    );
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getNumeroDocumento() {
        return super.getNumeroDocumento();
    }

    public BigDecimal getSalario() {
        return salario;
    }

    private void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getSalarioProporcional() {
        return salarioProporcional;
    }

    private void setSalarioProporcional(BigDecimal salarioProporcional) {
        this.salarioProporcional = salarioProporcional;
    }

    public int getQuantidadeDiasTrabalhado() {
        return quantidadeDiasTrabalhado;
    }

    private void setQuantidadeDiasTrabalhado(int quantidadeDiasTrabalhado) {
        this.quantidadeDiasTrabalhado = quantidadeDiasTrabalhado;
    }

    public void imprimirHollerite(String formatoApresentacaoData){
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------------").append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Dia e Horario da Impressão: ").append(pegarDataAtual(formatoApresentacaoData)).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Nome do Funcionário: ").append(this.getNome().toUpperCase()).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- CPF do Funcionário: ").append(formatarCPF()).append("\n");
        sb.append(criaLinhaSeparacaoHollertite()).append("\n");
        sb.append("- Dias Úteis: " + DIAS_UTEIS_MES_DE_TRABALHO + " dias").append("\n");
        sb.append("- Salario do Funcionário: ").append(formatarValoresEmMoedaLocal(this.getSalario())).append("\n");
        sb.append("- Dias Reais Trabalhados pelo Funcionário: ").append(this.getQuantidadeDiasTrabalhado()).append(" dias").append("\n");
        sb.append("- Salario Proporcional de Funcionário: R$").append(formatarValoresEmMoedaLocal(this.getSalarioProporcional())).append("\n");
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

    private String pegarDataAtual(String formato){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato);
        return formatador.format(data);
    }

    private String criaLinhaSeparacaoHollertite(){
        return "-                                                      -";
    }

    private String formatarCPF(){
        StringBuilder cpfBlocos = new StringBuilder();
        char[] charBloco = super.getNumeroDocumento().toCharArray();

        for (int i = 0; i < charBloco.length; i++) {
            if (i ==2) {
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 5){
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 8){
                cpfBlocos.append(charBloco[i]).append("-");
            } else {
                cpfBlocos.append(charBloco[i]);
            }
        }
        return cpfBlocos.toString();
    }

    public String formatarValoresEmMoedaLocal(BigDecimal valor) {
        String valorFormatado;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        valorFormatado = nf.format(Objects.requireNonNullElseGet(valor, () -> new BigDecimal(0.00)));

        return valorFormatado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{ ");
        sb.append("nome= '").append(this.getNome()).append('\'');
        sb.append(", numero documento= '").append(formatarCPF()).append('\'');
        sb.append(", salario= ").append(formatarValoresEmMoedaLocal(this.getSalario()));
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(super.getNumeroDocumento(), that.getNumeroDocumento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getNome(), super.getNumeroDocumento());
    }
}

