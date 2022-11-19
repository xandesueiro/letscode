package br.com.letscode.estudo;

import java.math.BigDecimal;
import java.util.Objects;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private BigDecimal salarioProporcional;
    private int quantidadeDiasTrabalhado;

    public static final int DIAS_UTEIS_MES_DE_TRABALHO = 22;


    public Funcionario( String strNome, String strCPF) {
        super(strNome, strCPF);
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

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getSalarioProporcional() {
        return salarioProporcional;
    }

    public void setSalarioProporcional(BigDecimal salarioProporcional) {
        this.salarioProporcional = salarioProporcional;
    }

    public int getQuantidadeDiasTrabalhado() {
        return quantidadeDiasTrabalhado;
    }

    public void setQuantidadeDiasTrabalhado(int quantidadeDiasTrabalhado) {
        this.quantidadeDiasTrabalhado = quantidadeDiasTrabalhado;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{ ");
        sb.append("nome= '").append(this.getNome()).append('\'');
        sb.append(", numero documento= '").append(this.getNumeroDocumento()).append('\'');
        sb.append(", salario= ").append(this.getSalario());
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        br.com.letscode.estudo.Funcionario that = (br.com.letscode.estudo.Funcionario) o;
        return Objects.equals(super.getNumeroDocumento(), that.getNumeroDocumento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getNome(), super.getNumeroDocumento());
    }
}


