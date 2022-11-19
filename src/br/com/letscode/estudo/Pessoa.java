package br.com.letscode.estudo;

import br.com.letscode.estudo.validacao.ValidacaoPessoa;
import br.com.letscode.presenter.exceptions.ValidacaoException;

import java.util.Objects;

public abstract class Pessoa implements Banco {

    protected String nome;
    protected String numeroDocumento;

    public Pessoa(String nome, String numeroDocumento) {
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(numeroDocumento, pessoa.numeroDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numeroDocumento);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pessoa{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", numeroDocumento='").append(numeroDocumento).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
