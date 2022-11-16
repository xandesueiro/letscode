package br.com.letscode.estudo;

import java.util.Objects;

public class Terceiro extends Pessoa {
    private String cnpjEmpresaContratante;


    public Terceiro(String nome, String numeroDocumento, String cnpjEmpresaContratante) {
        super(nome, numeroDocumento);
        this.cnpjEmpresaContratante = cnpjEmpresaContratante;
    }

    public String getCnpjEmpresaContratante() {
        return cnpjEmpresaContratante;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Terceiro{");
        sb.append("nome='").append(super.getNome()).append(", \'");
        sb.append("documento='").append(super.getNumeroDocumento()).append(", \'");
        sb.append("cnpjEmpresaContratante='").append(cnpjEmpresaContratante).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //TODO: rever condição de igualdade. Considerar classe pai
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terceiro terceiro = (Terceiro) o;
        return Objects.equals(cnpjEmpresaContratante, terceiro.cnpjEmpresaContratante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpjEmpresaContratante);
    }
}
