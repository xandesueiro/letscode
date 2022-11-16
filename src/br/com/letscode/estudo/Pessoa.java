package br.com.letscode.estudo;

public class Pessoa implements Banco{

    private String nome;
    private String numeroDocumento;

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
}
